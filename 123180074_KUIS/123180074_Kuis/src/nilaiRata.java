public class nilaiRata 
{
    public float rata (int total) 
    {
        return(total/2); 
    }
    
    public String nilaiHuruf(int total)  
    {
        if ((total/2)>=80 && (total/2)<=100) 
            return "A";
        else if ((total/2)>=75 && (total/2)<80) 
            return "B+";
        else if ((total/2)>=65 && (total/2)<75) 
            return "B";
        else if ((total/2)>=60 && (total/2)<65) 
            return "C+";
        else if ((total/2)>=50 && (total/2)<60) 
            return "C";
        else if ((total/2)>=20 && (total/2)<50) 
            return "D";
        else if ((total/2)>=0 && (total/2)<20) 
            return "E";
        else 
            return "Error";
    }
}
