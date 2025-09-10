.MODEL SMALL
.STACK 100H

.DATA 
    prompt1   DB 13,10,"Enter the 1st number: $"
    prompt2   DB 13,10,"Enter the 2nd number: $"
    promptyes DB 13,10,"Second number < first$"
    promptno  DB 13,10,"Second number >= first$"

.CODE
MAIN PROC
    MOV AX,@DATA
    MOV DS,AX

    XOR BX,BX
    MOV CL,4
    LEA DX,prompt1
    MOV AH,9
    INT 21H
    MOV AH,1
    INT 21H
IN1:
    CMP AL,0DH
    JE NXT1
    CMP AL,'9'
    JG L1
    AND AL,0FH
    JMP SH1
L1: SUB AL,37H
SH1:SHL BX,CL
    OR BL,AL
    INT 21H
    JMP IN1
NXT1:
    XOR DX,DX
    LEA DX,prompt2
    MOV AH,9
    INT 21H
    MOV AH,1
    INT 21H
IN2:
    CMP AL,0DH
    JE CMPNUM
    CMP AL,'9'
    JG L2
    AND AL,0FH
    JMP SH2
L2: SUB AL,37H
SH2:SHL DX,CL
    OR DL,AL
    INT 21H
    JMP IN2
CMPNUM:
    CMP BX,DX
    JG LESS
    LEA DX,promptno
    MOV AH,9
    INT 21H
    JMP EXIT
LESS:
    LEA DX,promptyes
    MOV AH,9
    INT 21H
EXIT:
    MOV AH,4CH
    INT 21H
MAIN ENDP
END MAIN
