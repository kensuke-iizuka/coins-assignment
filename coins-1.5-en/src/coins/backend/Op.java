/* ----------------------------------------------------------
%   Copyright (C) 2004 The Coins Project Group               
%       (Read COPYING for detailed information.)             
----------------------------------------------------------- */
// DO NOT EDIT THIS FILE DIRECTLY; Edit Op.pattern instead.
package coins.backend;

import java.util.HashMap;
import java.util.Map;

/** Operator mnemonic encoder/decoder.
 *   operator mnemonic are represented in int, not an instance of the class. */
public class Op {
 public static final int HOLE = 1;
 public static final int INTCONST = 2;
 public static final int FLOATCONST = 3;
 public static final int STATIC = 4;
 public static final int FRAME = 5;
 public static final int REG = 6;
 public static final int SUBREG = 7;
 public static final int LABEL = 8;
 public static final int NEG = 9;
 public static final int ADD = 10;
 public static final int SUB = 11;
 public static final int MUL = 12;
 public static final int DIVS = 13;
 public static final int DIVU = 14;
 public static final int MODS = 15;
 public static final int MODU = 16;
 public static final int CONVSX = 17;
 public static final int CONVZX = 18;
 public static final int CONVIT = 19;
 public static final int CONVFX = 20;
 public static final int CONVFT = 21;
 public static final int CONVFI = 22;
 public static final int CONVFS = 23;
 public static final int CONVFU = 24;
 public static final int CONVSF = 25;
 public static final int CONVUF = 26;
 public static final int BAND = 27;
 public static final int BOR = 28;
 public static final int BXOR = 29;
 public static final int BNOT = 30;
 public static final int LSHS = 31;
 public static final int LSHU = 32;
 public static final int RSHS = 33;
 public static final int RSHU = 34;
 public static final int TSTEQ = 35;
 public static final int TSTNE = 36;
 public static final int TSTLTS = 37;
 public static final int TSTLES = 38;
 public static final int TSTGTS = 39;
 public static final int TSTGES = 40;
 public static final int TSTLTU = 41;
 public static final int TSTLEU = 42;
 public static final int TSTGTU = 43;
 public static final int TSTGEU = 44;
 public static final int ASMCONST = 45;
 public static final int PURE = 46;
 public static final int MEM = 47;
 public static final int SET = 48;
 public static final int JUMP = 49;
 public static final int JUMPC = 50;
 public static final int JUMPN = 51;
 public static final int DEFLABEL = 52;
 public static final int CALL = 53;
 public static final int PROLOGUE = 54;
 public static final int EPILOGUE = 55;
 public static final int PARALLEL = 56;
 public static final int USE = 57;
 public static final int CLOBBER = 58;
 public static final int PHI = 59;
 public static final int IF = 60;
 public static final int LIST = 61;
 public static final int UNDEFINED = 62;
 public static final int SPACE = 63;
 public static final int ZEROS = 64;
 public static final int LINE = 65;
 public static final int INFO = 66;
 public static final int ASM = 67;
 public static final int STRING = 68;
 public static final int MAX = 69;
  static String[] opNames = {
 "dummy",
 "HOLE",
 "INTCONST",
 "FLOATCONST",
 "STATIC",
 "FRAME",
 "REG",
 "SUBREG",
 "LABEL",
 "NEG",
 "ADD",
 "SUB",
 "MUL",
 "DIVS",
 "DIVU",
 "MODS",
 "MODU",
 "CONVSX",
 "CONVZX",
 "CONVIT",
 "CONVFX",
 "CONVFT",
 "CONVFI",
 "CONVFS",
 "CONVFU",
 "CONVSF",
 "CONVUF",
 "BAND",
 "BOR",
 "BXOR",
 "BNOT",
 "LSHS",
 "LSHU",
 "RSHS",
 "RSHU",
 "TSTEQ",
 "TSTNE",
 "TSTLTS",
 "TSTLES",
 "TSTGTS",
 "TSTGES",
 "TSTLTU",
 "TSTLEU",
 "TSTGTU",
 "TSTGEU",
 "ASMCONST",
 "PURE",
 "MEM",
 "SET",
 "JUMP",
 "JUMPC",
 "JUMPN",
 "DEFLABEL",
 "CALL",
 "PROLOGUE",
 "EPILOGUE",
 "PARALLEL",
 "USE",
 "CLOBBER",
 "PHI",
 "IF",
 "LIST",
 "UNDEFINED",
 "SPACE",
 "ZEROS",
 "LINE",
 "INFO",
 "ASM",
 "STRING",
  };

  static boolean[] typed = {
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 true,
 false,
 false,
 true,
 true,
 false,
 false,
 false,
 false,
 false,
 false,
 false,
 false,
 false,
 false,
 true,
 true,
 false,
 false,
 false,
 false,
 false,
 false,
 false,
 false,
  };

  private static final Map table;

  // Inhibit invokation of constructor.
  private Op() {}

  static {
    // initialize name table
    table = new HashMap();
    for (int i = 0; i < Op.MAX; i++)
      table.put(opNames[i], new Integer(i));
  }

  /** Convert operator mnemonic to integer code */
  public static int toCode(String name) {
    Integer code = (Integer)table.get(name);
    if (code == null)
      return -1;
      //  throw new Error("Unknown opcode: " + name);
    return code.intValue();
  }

  /** Convert operator code to mnemonic */
  public static String toName(int code) {
    return opNames[code];
  }

  /** Return true if the operator is typed. */
  public static boolean isTyped(int code) {
    return typed[code];
  }
}
