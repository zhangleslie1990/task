public class demo8 {
    public static void main(String[] args) {

    }
    public  static  void fangfa1(){
        for(int i=0;i<10;i++){
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("第"+i+"次执行");
        }
    }
}
