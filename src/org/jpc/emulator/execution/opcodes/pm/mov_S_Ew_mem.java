package org.jpc.emulator.execution.opcodes.pm;

import org.jpc.emulator.execution.*;
import org.jpc.emulator.execution.decoder.*;
import org.jpc.emulator.processor.*;
import org.jpc.emulator.processor.fpu64.*;
import static org.jpc.emulator.processor.Processor.*;

public class mov_S_Ew_mem extends Executable
{
    final int segIndex;
    final Pointer op2;

    public mov_S_Ew_mem(int blockStart, Instruction parent)
    {
        super(blockStart, parent);
        segIndex = Processor.getSegmentIndex(parent.operand[0].toString());
        op2 = new Pointer(parent.operand[1], parent.adr_mode);
    }

    public Branch execute(Processor cpu)
    {
        if (segIndex == 0)
            throw ProcessorException.UNDEFINED;
        cpu.setSeg(segIndex, (short)op2.get16(cpu));
        if (segIndex == Processor.getSegmentIndex("ss"))
        {
            cpu.eflagsInterruptEnable = false;
        }
        return Branch.None;
    }

    public boolean isBranch()
    {
        return false;
    }

    public String toString()
    {
        return this.getClass().getName();
    }
}