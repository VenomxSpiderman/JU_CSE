.MODEL SMALL
.STACK 100H

.DATA
    prompt1 DB 13,10,"Enter the first number: $"
    prompt2 DB 13,10,"Enter the second number: $"
    prompt3 DB 13,10,"The result of the addition is: $"

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
    JE CALC
    CMP AL,'9'
    JG L2
    AND AL,0FH
    JMP SH2
L2: SUB AL,37H
SH2:SHL DX,CL
    OR DL,AL
    INT 21H
    JMP IN2
CALC:
    MOV CX,DX
    ADD BX,CX
    JNC DISP
    MOV DL,'1'
    MOV AH,2
    INT 21H
DISP:
    LEA DX,prompt3
    MOV AH,9
    INT 21H
    MOV CH,BH
    MOV CL,4
    SHR CH,CL
    AND CH,0FH
    CALL HEXOUT
    MOV CH,BH
    AND CH,0FH
    CALL HEXOUT
    MOV CH,BL
    SHR CH,CL
    AND CH,0FH
    CALL HEXOUT
    MOV CH,BL
    AND CH,0FH
    CALL HEXOUT
    MOV AH,4CH
    INT 21H
MAIN ENDP

HEXOUT PROC
    CMP CH,10
    JL DIG
    ADD CH,7
DIG:ADD CH,'0'
    MOV DL,CH
    MOV AH,2
    INT 21H
    RET
HEXOUT ENDP
END MAIN
