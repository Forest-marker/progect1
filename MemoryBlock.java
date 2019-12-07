package Malloc;
//内存块的状态
//包含属性起始地址，大小，状态
public class MemoryBlock {
    private int startAddress;
    private int size;
    private String state;//内存开状态
    public MemoryBlock(){

    }
    //构造方法初始化
    public MemoryBlock (String programNmae,int startAddress,int size){
        this.state=programNmae;
        this.startAddress=startAddress;
        this.size=size;
    }
    //设置
    public void setStartAddress(int startAddress){
        this.startAddress=startAddress;
    }
    //获取
    public int getStartAddress(){
        return this.startAddress;
    }
    public  void setSize(int size){
        this.size=size;
    }
    public int getSize(){
        return this.size;
    }
    public void setState(String date){
        this.size=size;
    }
    public String getState(){
        return this.state;
    }
    public String toString(){
       // return("[state:"+state+",startAddress:"+startAddress+",size:"+size+"]");
        return(state+" "+startAddress +" "+size);
    }
}
