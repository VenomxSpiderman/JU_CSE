.model small
.stack 100h
.data
    year    dw 0          ; Changed to dw (word) to hold the 4-digit year
    month   db 0
    day     db 0
    hours   db 0
    minutes db 0
    msg1    db 13,10,"Date:  $"
    msg2    db 13,10,"Time:  $"
    char1   db "/$"
    colon   db ":$"       ; Added for time formatting
    endl    db 13,10,"$"
.code

; Macro to print a message
print macro msg
    push ax
    push dx
    mov ah, 09h
    lea dx, msg
    int 21h
    pop dx
    pop ax
endm

main proc
    mov ax, @data
    mov ds, ax

    ; Get System Date
    mov ah, 2ah
    int 21h
    mov year, cx      ; Store year (CX)
    mov month, dh     ; Store month (DH)
    mov day, dl       ; Store day (DL)

    ; Get System Time
    mov ah, 2ch
    int 21h
    mov hours, ch     ; Store hours (CH)
    mov minutes, cl   ; Store minutes (CL)

    ; --- Print the Date ---
    print msg1

    mov ax, year      ; Load year into AX
    call writenum     ; Print it
    print char1

    mov al, month     ; Load month into AL
    xor ah, ah        ; Clear AH to safely use AX
    call writenum     ; Print it
    print char1

    mov al, day       ; Load day into AL
    xor ah, ah        ; Clear AH
    call writenum     ; Print it (FIXED)

    ; --- Print the Time --- (ADDED)
    print msg2

    mov al, hours     ; Load hours into AL
    xor ah, ah        ; Clear AH
    call writenum     ; Print it
    print colon

    mov al, minutes   ; Load minutes into AL
    xor ah, ah        ; Clear AH
    call writenum     ; Print it

    ; Exit program
    mov ah, 4ch
    int 21h
main endp

; Procedure to write a number in AX to the screen
writenum proc near
    push ax
    push bx
    push cx
    push dx
    xor cx, cx          ; Clear digit counter
    mov bx, 10          ; Set divisor to 10
@output:
    xor dx, dx          ; Clear dx for division
    div bx              ; ax = ax / 10, dx = remainder
    push dx             ; Push remainder (digit) onto stack
    inc cx              ; Increment digit count
    or ax, ax           ; Check if ax is zero
    jne @output         ; If not zero, repeat
    
    mov ah, 02h         ; Function to print a character
@display:
    pop dx              ; Pop digit from stack
    or dl, 30h          ; Convert digit to ASCII character
    int 21h             ; Print character
    loop @display       ; Loop for all digits
    
    pop dx
    pop cx
    pop bx
    pop ax
    ret
writenum endp

end main
