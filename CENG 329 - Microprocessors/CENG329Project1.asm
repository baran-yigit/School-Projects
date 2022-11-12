;-------------------------------------------------------------------------------
; MSP430 Assembler Code Template for use with TI Code Composer Studio
;
;
;-------------------------------------------------------------------------------
            .cdecls C,LIST,"msp430.h"       ; Include device header file
            
;-------------------------------------------------------------------------------
            .def    RESET                   ; Export program entry-point to
                                            ; make it known to linker.
;-------------------------------------------------------------------------------
            .text                           ; Assemble into program memory.
            .retain                         ; Override ELF conditional linking
                                            ; and retain current section.
            .retainrefs                     ; And retain any sections that have
                                            ; references to current section.

;-------------------------------------------------------------------------------
RESET       mov.w   #__STACK_END,SP         ; Initialize stackpointer
StopWDT     mov.w   #WDTPW|WDTHOLD,&WDTCTL  ; Stop watchdog timer


;-------------------------------------------------------------------------------
; Main loop here
;-------------------------------------------------------------------------------
		;Link: https://youtu.be/1ASEq0dpLm0  Baran Yigit 201711071
		bic.b	#BIT1|BIT2|BIT3|BIT4, &P1OUT
		mov.b	#0, r4
		bic.b  	#00011110b, &P1SEL
 		bic.b   #00011110b, &P1SEL2
		bis.b   #00010110b, &P1DIR
Mloop:	bic.b	#BIT1|BIT2|BIT4, &P1OUT
		bic.b	#BIT1, &P1OUT
		bis.b	#BIT1, &P1OUT
		cmp.b	#0, r4
		bic.b	#BIT1, &P1OUT
		bis.b	#BIT1, &P1OUT
       	jeq		Red
       	bic.b	#BIT1, &P1OUT
		bis.b	#BIT1, &P1OUT
       	cmp.b	#3, r4
       	bic.b	#BIT1, &P1OUT
		bis.b	#BIT1, &P1OUT
       	jeq		Red
Mloop1:	bic.b	#BIT1|BIT2|BIT4, &P1OUT
		bic.b	#BIT2, &P1OUT
		bis.b	#BIT2, &P1OUT
		cmp.b	#1, r4
		bic.b	#BIT2, &P1OUT
		bis.b	#BIT2, &P1OUT
		jeq		Yellow
		bic.b	#BIT2, &P1OUT
		bis.b	#BIT2, &P1OUT
		cmp.b	#4, r4
		bic.b	#BIT2, &P1OUT
		bis.b	#BIT2, &P1OUT
		jeq		Yellow
Mloop2:	bic.b	#BIT1|BIT2|BIT4, &P1OUT
		bic.b	#BIT4, &P1OUT
		bis.b	#BIT4, &P1OUT
		cmp.b	#2, r4
		bic.b	#BIT4, &P1OUT
		bis.b	#BIT4, &P1OUT
		jeq		Green
		bic.b	#BIT4, &P1OUT
		bis.b	#BIT4, &P1OUT
		cmp.b	#5, r4
		bic.b	#BIT4, &P1OUT
		bis.b	#BIT4, &P1OUT
		jeq		Green
Red:	bic.b	#BIT1|BIT2|BIT3|BIT4, &P1OUT
		bic.b	#BIT1, &P1OUT
		bis.b	#BIT1, &P1OUT
		add.b	#1, r4
		bic.b	#BIT1, &P1OUT
		bis.b	#BIT1, &P1OUT
		mov.w	#-65530, r5
		bic.b	#BIT1, &P1OUT
		bis.b	#BIT1, &P1OUT
		jmp		Dloop
Yellow:	bic.b	#BIT2, &P1OUT
		bis.b	#BIT2, &P1OUT
		add.b	#1, r4
		bic.b	#BIT2, &P1OUT
		bis.b	#BIT2, &P1OUT
		mov.w	#-65530, r5
		bic.b	#BIT2, &P1OUT
		bis.b	#BIT2, &P1OUT
		jmp		Dloop1
Green:	bic.b	#BIT4, &P1OUT
		bis.b	#BIT4, &P1OUT
		add.b	#1, r4
		bic.b	#BIT4, &P1OUT
		bis.b	#BIT4, &P1OUT
		mov.w	#-65530, r5
		bic.b	#BIT4, &P1OUT
		bis.b	#BIT4, &P1OUT
		jmp 	Dloop2
Dloop:	bic.b	#BIT1, &P1OUT
		bis.b	#BIT1, &P1OUT
		sub.w	#1, r5
		bic.b	#BIT1, &P1OUT
		bis.b	#BIT1, &P1OUT
		cmp.w 	#4,r5
		bic.b	#BIT1, &P1OUT
		bis.b	#BIT1, &P1OUT
		jne 	Dloop
		bic.b	#BIT1, &P1OUT
		bis.b	#BIT1, &P1OUT
		jmp		Mloop1
		bic.b	#BIT1|BIT2|BIT3|BIT4, &P1OUT
Dloop1:	bic.b	#BIT2, &P1OUT
		bis.b	#BIT2, &P1OUT
		sub.w	#1, r5
		bic.b	#BIT2, &P1OUT
		bis.b	#BIT2, &P1OUT
		cmp.w 	#4,r5
		bic.b	#BIT2, &P1OUT
		bis.b	#BIT2, &P1OUT
		jne 	Dloop1
		bic.b	#BIT2, &P1OUT
		bis.b	#BIT2, &P1OUT
		jmp		Mloop2
		bic.b	#BIT1|BIT2|BIT3|BIT4, &P1OUT
Dloop2:	bic.b	#BIT4, &P1OUT
		bis.b	#BIT4, &P1OUT
		sub.w	#1, r5
		bic.b	#BIT4, &P1OUT
		bis.b	#BIT4, &P1OUT
		cmp.w 	#4,r5
		bic.b	#BIT4, &P1OUT
		bis.b	#BIT4, &P1OUT
		jne 	Dloop2
		bic.b	#BIT4, &P1OUT
		bis.b	#BIT4, &P1OUT
		jmp		Mloop
		bic.b	#BIT1|BIT2|BIT3|BIT4, &P1OUT
;-------------------------------------------------------------------------------
; Stack Pointer definition
;-------------------------------------------------------------------------------
            .global __STACK_END
            .sect   .stack
            
;-------------------------------------------------------------------------------
; Interrupt Vectors
;-------------------------------------------------------------------------------
            .sect   ".reset"                ; MSP430 RESET Vector
            .short  RESET
            
