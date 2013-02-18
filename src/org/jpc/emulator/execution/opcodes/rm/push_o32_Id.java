package org.jpc.emulator.execution.opcodes.rm;

import org.jpc.emulator.execution.*;
import org.jpc.emulator.execution.decoder.*;
import org.jpc.emulator.processor.*;
import org.jpc.emulator.processor.fpu64.*;
import static org.jpc.emulator.processor.Processor.*;

public class push_o32_Id extends Executable
{
    final int immd;

    public push_o32_Id(int blockStart, Instruction parent)
    {
        super(blockStart, parent);
        immd = (int)parent.operand[0].lval;
    }

    public Branch execute(Processor cpu)
    {
        cpu.push32(immd);
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