package org.jpc.emulator.execution.opcodes.pm;

import org.jpc.emulator.execution.*;
import org.jpc.emulator.execution.decoder.*;
import org.jpc.emulator.processor.*;
import static org.jpc.emulator.processor.Processor.*;

public class call_o16_Ev_mem extends Executable
{
    final Pointer op1;
    final int blockLength;
    final int instructionLength;
    final int size;

    public call_o16_Ev_mem(int blockStart, Instruction parent)
    {
        super(blockStart, parent);
        size = parent.opr_mode;
        blockLength = parent.x86Length+(int)parent.eip-blockStart;
        instructionLength = parent.x86Length;
        op1 = new Pointer(parent.operand[0], parent.adr_mode);
    }

    public Branch execute(Processor cpu)
    {
        if (size == 16)
        {
                int tempEIP = op1.get16(cpu) & 0xffff;
        cpu.cs.checkAddress(tempEIP);
        if ((cpu.r_sp.get16() < 2) && (cpu.r_sp.get16() > 0))
	    throw ProcessorException.STACK_SEGMENT_0;
        cpu.eip += blockLength;
        cpu.push16((short)cpu.eip);
        cpu.eip = tempEIP;
        }
        else if (size == 32)
        {
                int tempEIP = op1.get32(cpu) & 0xffff;
        cpu.cs.checkAddress(tempEIP);
        if ((cpu.r_sp.get16() < 2) && (cpu.r_sp.get16() > 0))
	    throw ProcessorException.STACK_SEGMENT_0;
        cpu.eip += blockLength;
        cpu.push16((short)cpu.eip);
        cpu.eip = tempEIP;
        }        else throw new IllegalStateException("Unknown size "+size);
        return Branch.Call_Unknown;
    }

    public boolean isBranch()
    {
        return true;
    }

    public String toString()
    {
        return this.getClass().getName();
    }
}