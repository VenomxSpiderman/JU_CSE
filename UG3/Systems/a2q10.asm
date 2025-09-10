.MODEL SMALL
.STACK 256H
.DATA
    MSG DB "Prime Numbers: $"
    NEWLINE DB 13, 10, '$' ; For newline after displaying primes
 
.CODE
MAIN PROC
    MOV AX, @DATA           ; Initialize DS to address of Data Segment
    MOV DS, AX              ; Set DS register
 
    ; Print the message
    LEA DX, MSG
    MOV AH, 09H             ; DOS function to display string
    INT 21H
 
    MOV AX, 2               ; Start checking from 2
    .WHILE AX <= 100         ; Check primes less than or equal to 100
        PUSH AX             ; Save current number to stack
        CALL CHECK_PRIME
        POP AX              ; Restore AX (current number)
        INC AX              ; Move to the next number
    .ENDW
 
    ; Print newline after listing primes
    LEA DX, NEWLINE
    MOV AH, 09H
    INT 21H
 
    MOV AH, 4CH             ; DOS function: Exit program
    INT 21H                 ; Call DOS
MAIN ENDP
 
CHECK_PRIME PROC NEAR
    MOV BX, 2               ; Start divisor from 2
    MOV CX, AX 
 
    ; Special case for 2 (2 is a prime number)
    CMP AX, 2
    JE @IS_PRIME            ; 2 is prime, jump to display
 
    .WHILE BX < CX    ; Check divisors up to sqrt(CX)
        XOR DX, DX          ; Clear DX for division
        DIV BX              ; AX / BX; result in AX, remainder in DX
        CMP DX, 0           ; Check remainder
        JE @NOT_PRIME       ; If remainder is 0, not prime
        INC BX              ; Move to the next divisor
        MOV AX, CX          ; Restore AX to original number
    .ENDW
 
@IS_PRIME:
    CALL writenum           ; Call to display the prime number
    RET
 
@NOT_PRIME:
    RET
CHECK_PRIME ENDP
 
writenum PROC NEAR
    PUSH AX                 ; Save AX
    PUSH BX                 ; Save BX
    PUSH CX                 ; Save CX
    PUSH DX                 ; Save DX
 
    XOR CX, CX              ; Clear CX for digit count
    MOV BX, 10              ; Set divisor to 10
 
@OUTPUT:
    XOR DX, DX              ; Clear DX
    DIV BX                  ; Divide AX by 10
    PUSH DX                 ; Push remainder (digit) onto stack
    INC CX                  ; Increment digit count
    OR AX, AX               ; Check if quotient is 0
    JNZ @OUTPUT             ; Loop if not 0
 
    MOV AH, 02H             ; DOS function to display character
 
@DISPLAY:
    POP DX                  ; Get digit from stack
    ADD DL, '0'             ; Convert to ASCII
    INT 21H                 ; Print character
    LOOP @DISPLAY           ; Loop until all digits are displayed
 
    ; Print a space after each number
    MOV DL, ' '             ; Space character
    INT 21H
 
    POP DX                  ; Restore DX

    POP CX                  ; Restore CX
    POP BX                  ; Restore BX
    POP AX                  ; Restore AX
    RET
writenum ENDP
END MAIN
 


