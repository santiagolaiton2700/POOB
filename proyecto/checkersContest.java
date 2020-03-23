    
    /**
     * Write a description of class CheckersContest here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class checkersContest
    {
        // instance variables - replace the example below with your own
        private checkers tablero;
        private String antes;
        private String despues;
        private boolean helpme;
        /**
         * Constructor for objects of class CheckersContest
         */
        public checkersContest(int medida)
        {
          helpme=true;
        }
    
        /**
         * An example of a method - replace this comment with your own
         * 
         * @param  y   a sample parameter for a method
         * @return     the sum of x and y 
         */
        public void solved(char jugador,String[] moves){
          if (helpme){             
            tablero= new checkers(8);
            tablero.add(false,1,2,"j2",1);
            tablero.add(true,4,1,"j2",1);
            tablero.add(false,4,5,"j1",1);
            tablero.add(true,5,6,"j1",1);
            tablero.add(false,6,1,"j1",1);
            tablero.add(false,7,4,"j1",1);
            tablero.add(false,7,6,"j1",1);        
            tablero.save("prueba1");
            antes=tablero.recovery("prueba1"); 
            helpme=false;
        }else{       
            tablero= new checkers(8);
            tablero.add(false,1,4,"j2",1);
            tablero.add(true,1,8,"j1",1);
            tablero.add(false,2,1,"j2",1);
            tablero.add(false,2,3,"j2",1);
            tablero.add(false,3,2,"j1",1);
            tablero.add(true,4,1,"j2",1);
            tablero.add(false,4,3,"j1",1);
            tablero.add(false,4,5,"j2",1);
            tablero.add(true,8,7,"j2",1);          
            tablero.save("prueba2");
            antes=tablero.recovery("prueba2");        
        }
        tablero.swap();      
        for (int i=0;i<moves.length;i++){
              tablero.moveArena(moves[i]); 
            }
            tablero.swap();
            tablero.save("solucion");
            despues=tablero.recovery("solucion");
            System.out.println(antes +"\n"+despues);
     } 
}
