/*
    JPC: An x86 PC Hardware Emulator for a pure Java Virtual Machine
    Release Version 2.4

    A project from the Physics Dept, The University of Oxford

    Copyright (C) 2007-2010 The University of Oxford

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License version 2 as published by
    the Free Software Foundation.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 
    Details (including contact information) can be found at: 

    javapc.sourceforge.net
             or
    www-jpc.physics.ox.ac.uk

    Conceived and Developed by:
    Rhys Newman, Ian Preston, Chris Dennis

    End of licence header
*/


package org.jpc.emulator.processor;

/**
 * 
 * @author Chris Dennis
 */
public class ModeSwitchException extends RuntimeException
{
    public static final ModeSwitchException PROTECTED_MODE_EXCEPTION = new ModeSwitchException();
    public static final ModeSwitchException REAL_MODE_EXCEPTION = new ModeSwitchException();
    public static final ModeSwitchException VIRTUAL8086_MODE_EXCEPTION = new ModeSwitchException();

    private ModeSwitchException()
    {
    }

    public String toString()
    {
        if (this == REAL_MODE_EXCEPTION)
            return "Switched to REAL mode";
        else if (this == PROTECTED_MODE_EXCEPTION)
            return "Switched to PROTECTED mode";
        else if (this == VIRTUAL8086_MODE_EXCEPTION)
	    return "Switched to VIRTUAL 8086 mode";
        else
            return "Switched to unknown mode";
    }
}
