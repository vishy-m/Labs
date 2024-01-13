public class Square
{
   public final static int EMPTY   = 0;
   public final static int WALL    = 1;
   public final static int START   = 2;
   public final static int EXIT    = 3;
   
   public final static char WORKING      = 'o';
   public final static char EXPLORED     = '.';
   public final static char ON_EXIT_PATH = 'x';
   public final static char UNKNOWN      = '_';
   
   
   private int type;
   private int row, col;
   private char status;
   
   public Square(int r, int c, int t)
   {
      row = r;
      col = c;
      type = t;
   }
   
   public String toString()
   {
      switch (type)
      {
         case (EMPTY):
            if (status == WORKING) 
               return "" + WORKING;
            if (status == EXPLORED) 
               return "" + EXPLORED;
            if (status == ON_EXIT_PATH) 
               return "" + ON_EXIT_PATH;
            return "_";
         case (WALL):
            return "#";
         case (START):
            return "S";
         case (EXIT):
            return "E";
         default:
            return "_";
      }
   }
   
   public boolean equals(Object obj)
   {
      Square sq = (Square)obj;
      
      if (sq.row == row && sq.col == col)
         return true;
      return false;
      
   }
   public int  getRow()    { 
      return row; }
   public int  getCol()    { 
      return col; }
   public int  getType()   {
      return type; }
   public char getStatus() {
      return status; }
      
   public void setStatus(char c) { status = c; }
   
   public void reset() { status = UNKNOWN; }

}