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
			;Video link: https://youtu.be/QXHG1DpQh3Y  201711071 Baran Yigit
			
			bic.b #01111111b, &P1SEL
			bic.b #01111111b, &P1SEL2
			bis.b #01111111b, &P1DIR
			bic.b #01111111b, &P2SEL
			bic.b #01111111b, &P2SEL2
			bis.b #01111111b, &P2DIR
			mov.b #0, R4
loop:		bit.b #BIT3, &P1IN
			bit.b #BIT3, &P2IN
			cmp.b #9, R4
			jl disp
			mov.b #0, R4
disp:		bis.b #01111111b, &P2OUT
			bic.b #01111111b, &P2OUT
			bis.b #01111111b, &P1OUT
			bic.b #01111111b, &P1OUT
			call #delay
        	mov.b #01111110b,P2OUT
        	mov.b #01111110b,P1OUT
        	call #delay
        	mov.b #00110000b,P1OUT
        	call #delay
        	mov.b #01101101b,P1OUT
        	call #delay
        	mov.b #01111001b,P1OUT
        	call #delay
        	mov.b #00110011b,P1OUT
        	call #delay
        	mov.b #01011011b,P1OUT
        	call #delay
        	mov.b #01011111b,P1OUT
        	call #delay
        	mov.b #01110000b,P1OUT
        	call #delay
        	mov.b #11111111b,P1OUT
        	call #delay
        	mov.b #01111011b,P1OUT
        	call #delay
        	mov.b #00110000b,P2OUT
			mov.b #01111110b,P1OUT
        	call #delay
        	mov.b #00110000b,P1OUT
        	call #delay
        	mov.b #01101101b,P1OUT
        	call #delay
        	mov.b #01111001b,P1OUT
        	call #delay
        	mov.b #00110011b,P1OUT
        	call #delay
        	mov.b #01011011b,P1OUT
        	call #delay
        	mov.b #01011111b,P1OUT
        	call #delay
        	mov.b #01110000b,P1OUT
        	call #delay
        	mov.b #11111111b,P1OUT
        	call #delay
        	mov.b #01111011b,P1OUT
        	call #delay
			mov.b #01101101b,P2OUT
			mov.b #01111110b,P1OUT
        	call #delay
        	mov.b #00110000b,P1OUT
        	call #delay
        	mov.b #01101101b,P1OUT
        	call #delay
        	mov.b #01111001b,P1OUT
        	call #delay
        	mov.b #00110011b,P1OUT
        	call #delay
        	mov.b #01011011b,P1OUT
        	call #delay
        	mov.b #01011111b,P1OUT
        	call #delay
        	mov.b #01110000b,P1OUT
        	call #delay
        	mov.b #11111111b,P1OUT
        	call #delay
        	mov.b #01111011b,P1OUT
        	call #delay
			mov.b #01111001b,P2OUT
			mov.b #01111110b,P1OUT
        	call #delay
        	mov.b #00110000b,P1OUT
        	call #delay
        	mov.b #01101101b,P1OUT
        	call #delay
        	mov.b #01111001b,P1OUT
        	call #delay
        	mov.b #00110011b,P1OUT
        	call #delay
        	mov.b #01011011b,P1OUT
        	call #delay
        	mov.b #01011111b,P1OUT
        	call #delay
        	mov.b #01110000b,P1OUT
        	call #delay
        	mov.b #11111111b,P1OUT
        	call #delay
        	mov.b #01111011b,P1OUT
        	call #delay
			mov.b #00110011b,P2OUT
			mov.b #01111110b,P1OUT
        	call #delay
        	mov.b #00110000b,P1OUT
        	call #delay
        	mov.b #01101101b,P1OUT
        	call #delay
        	mov.b #01111001b,P1OUT
        	call #delay
        	mov.b #00110011b,P1OUT
        	call #delay
        	mov.b #01011011b,P1OUT
        	call #delay
        	mov.b #01011111b,P1OUT
        	call #delay
        	mov.b #01110000b,P1OUT
        	call #delay
        	mov.b #11111111b,P1OUT
        	call #delay
        	mov.b #01111011b,P1OUT
        	call #delay
			mov.b #01011011b,P2OUT
			mov.b #01111110b,P1OUT
        	call #delay
        	mov.b #00110000b,P1OUT
        	call #delay
        	mov.b #01101101b,P1OUT
        	call #delay
        	mov.b #01111001b,P1OUT
        	call #delay
        	mov.b #00110011b,P1OUT
        	call #delay
        	mov.b #01011011b,P1OUT
        	call #delay
        	mov.b #01011111b,P1OUT
        	call #delay
        	mov.b #01110000b,P1OUT
        	call #delay
        	mov.b #11111111b,P1OUT
        	call #delay
        	mov.b #01111011b,P1OUT
        	call #delay
			mov.b #01011111b,P2OUT
			mov.b #01111110b,P1OUT
        	call #delay
        	mov.b #00110000b,P1OUT
        	call #delay
        	mov.b #01101101b,P1OUT
        	call #delay
        	mov.b #01111001b,P1OUT
        	call #delay
        	mov.b #00110011b,P1OUT
        	call #delay
        	mov.b #01011011b,P1OUT
        	call #delay
        	mov.b #01011111b,P1OUT
        	call #delay
        	mov.b #01110000b,P1OUT
        	call #delay
        	mov.b #11111111b,P1OUT
        	call #delay
        	mov.b #01111011b,P1OUT
        	call #delay
			mov.b #01110000b,P2OUT
			mov.b #01111110b,P1OUT
        	call #delay
        	mov.b #00110000b,P1OUT
        	call #delay
        	mov.b #01101101b,P1OUT
        	call #delay
        	mov.b #01111001b,P1OUT
        	call #delay
        	mov.b #00110011b,P1OUT
        	call #delay
        	mov.b #01011011b,P1OUT
        	call #delay
        	mov.b #01011111b,P1OUT
        	call #delay
        	mov.b #01110000b,P1OUT
        	call #delay
        	mov.b #11111111b,P1OUT
        	call #delay
        	mov.b #01111011b,P1OUT
        	call #delay
			mov.b #11111111b,P2OUT
			mov.b #01111110b,P1OUT
        	call #delay
        	mov.b #00110000b,P1OUT
        	call #delay
        	mov.b #01101101b,P1OUT
        	call #delay
        	mov.b #01111001b,P1OUT
        	call #delay
        	mov.b #00110011b,P1OUT
        	call #delay
        	mov.b #01011011b,P1OUT
        	call #delay
        	mov.b #01011111b,P1OUT
        	call #delay
        	mov.b #01110000b,P1OUT
        	call #delay
        	mov.b #11111111b,P1OUT
        	call #delay
        	mov.b #01111011b,P1OUT
        	call #delay
			mov.b #01111011b,P2OUT
			mov.b #01111110b,P1OUT
        	call #delay
        	mov.b #00110000b,P1OUT
        	call #delay
        	mov.b #01101101b,P1OUT
        	call #delay
        	mov.b #01111001b,P1OUT
        	call #delay
        	mov.b #00110011b,P1OUT
        	call #delay
        	mov.b #01011011b,P1OUT
        	call #delay
        	mov.b #01011111b,P1OUT
        	call #delay
        	mov.b #01110000b,P1OUT
        	call #delay
        	mov.b #11111111b,P1OUT
        	call #delay
        	mov.b #01111011b,P1OUT
        	call #delay
			mov.b #01111110b,P1OUT
			mov.b #01111110b,P2OUT
			add.b #1, R4
			jmp loop
delay:		push R5
			mov.w #0, R5
dloop:		push R6
			push R6
			pop R6
			pop R6
			add.w #1, R5
			jne dloop
			pop R5
			ret

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
            
