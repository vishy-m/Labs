public class Square {

   public static final int EMPTY = 0;
   public static final int WALL = 1;
   public static final int START = 2;
   public static final int EXIT = 3;
   
   private int type, row, col;
   private char status = '_';
   private Square previous;
   
   public Square(int row, int col, int type) {
      this.row = row;
      this.col = col;
      this.type = type;      
      previous = null;   
   }
   
   public int getRow() { 
      return row; 
   }
   public int getCol() { 
      return col; 
   }
   public int getType() { 
      return type; 
   }
   public int getStatus() { 
      return status; 
   }
   public void setStatus(char c) {
      status = c;
   }        
   public Square getPrevious() { 
      return previous; 
   }
   public void setPrevious(Square p) {
      if (previous == null)
         previous = p;
   }        

   public void reset() {
      status = '_';
      previous = null;
   }
   
   @Override
   public boolean equals(Object obj) {
      if (! (obj instanceof Square))
         return false;
      Square other = (Square) obj;
      return this.row == other.row && this.col == other.col;
   }
   
   @Override
   public String toString() {
      switch (type) {
         case WALL : 
            return "#";
         case EXIT : 
            return "E";
         case START : 
            return "S";            
         default : 
            return status+"";  //EMPTY
      }
   
   }


}