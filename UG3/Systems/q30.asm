.MODEL SMALL
.STACK 100h

.DATA
    msg1 DB "Enter first hex digit (0-9 or A-F): $"
    msg2 DB 0Dh,0Ah, "Enter second hex digit (0-9 or A-F): $"
    msg3 DB 0Dh,0Ah, "Sum = $"
    digit1 DB ?
    digit2 DB ?
    sum DB ?

.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX

    ; Prompt and read first hex digit
    LEA DX, msg1
    MOV AH, 09h
    INT 21h

    MOV AH, 01h ; read char
    INT 21h
    MOV digit1, AL

    ; Convert ASCII hex to binary value
    CALL HEX_TO_BIN
    MOV BL, AL ; BL = first number

    ; Prompt and read second hex digit
    LEA DX, msg2
    MOV AH, 09h
    INT 21h

    MOV AH, 01h
    INT 21h
    MOV digit2, AL

    ; Convert ASCII hex to binary value
    CALL HEX_TO_BIN
    ADD BL, AL ; BL = BL + second number
    MOV sum, BL

    ; Print "Sum = "
    LEA DX, msg3
    MOV AH, 09h
    INT 21h

    ; Convert result back to hex string and display
    MOV AL, sum
    CALL BIN_TO_HEX

    ; Exit program
    MOV AH, 4Ch
    XOR AL, AL
    INT 21h
MAIN ENDP

HEX_TO_BIN PROC
    CMP AL, '9'
    JG LETTER
    SUB AL, '0'
    RET
LETTER:
    SUB AL, 'A'
    ADD AL, 10
    RET
HEX_TO_BIN ENDP

BIN_TO_HEX PROC
    PUSH AX
    PUSH BX
    MOV BL, AL ; copy number
    MOV CL, 4
    SHR AL, CL ; upper nibble in AL
    CALL NIBBLE_TO_ASCII
    MOV DL, AL
    MOV AH, 02h
    INT 21h
    MOV AL, BL ; lower nibble
    AND AL, 0Fh
    CALL NIBBLE_TO_ASCII
    MOV DL, AL
    MOV AH, 02h
    INT 21h
    POP BX
    POP AX
    RET
BIN_TO_HEX ENDP

NIBBLE_TO_ASCII PROC
    CMP AL, 9
    JG LETTER2
    ADD AL, '0'
    RET
LETTER2:
    ADD AL, 'A' - 10
    RET
NIBBLE_TO_ASCII ENDP

END MAIN

