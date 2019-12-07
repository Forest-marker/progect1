package Malloc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MemoryManagement {
    //建立两个列表，一个用来存放已分配的块
    public ArrayList<MemoryBlock> usedBlock;
    //一个存放未分配的块
    public ArrayList<MemoryBlock> unusedBlock;
    //门限值
    public int limit;
    //输入选择哪个分配算法（1-3）
    public int memoryAllocation;

    public int temp=0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //初始化
        MemoryManagement p = new MemoryManagement();
        //先初始化
        p.Init();
        //再调菜单
        p.menu();
        //提示输入选择哪个算法，用户输入
        System.out.println("请选择内存分配算法:");
        p.memoryAllocation = scanner.nextInt();
        System.out.println("请输入门限值:");
        p.limit=scanner.nextInt();

        String Orallocation;//分配还是回收
        String programName ;
        int programSize ;
        while (true) {
            System.out.println("===================");
            System.out.println("请输入[malloc id size]or[recover id size]");
            //输入malloc or recover
            //输入进程的id,大小
            Orallocation = scanner.next();
            if (Orallocation.equals("malloc")) {
                programName  = scanner.next();
                programSize  = scanner.nextInt();
                p.runAllocate(programName,programSize);
            }else if(Orallocation .equals("recover")){
                programName=scanner.next();
                //programSize =scanner.nextInt();
                p.recover(programName );
            }else{
                System.out.println("输入有误，请重新输入");
            }
            System.out.println("=======================");


        }
    }


    //中间状态的内存情况
        public void Init() {
        //列表的类型都是MemoryBlock类类型的
            usedBlock = new ArrayList<MemoryBlock>();
            unusedBlock = new ArrayList<MemoryBlock>();
            //初始化分配列表中的块
            usedBlock.add(new MemoryBlock("A", 0, 500));
            usedBlock.add(new MemoryBlock("B", 5500, 500));
            usedBlock.add(new MemoryBlock("C", 2500, 1500));
            usedBlock.add(new MemoryBlock("D", 500, 800));
            //初始化未分配列表中的块
            unusedBlock.add(new MemoryBlock("unused", 1300, 1200));
            unusedBlock.add(new MemoryBlock("unused", 4000, 1500));
            //输出
            print();
        }

        public void print(){
        //开创出一个临时的ArrayList，供之后合并使用
        ArrayList<MemoryBlock> aList=new ArrayList<MemoryBlock>();
        //按内存块首地址升序打印
        unusedBlock .sort(new FirstAdapation() );
        usedBlock .sort(new FirstAdapation() );
        //打印已分配内存块表，打印时并存入临时列表中
            System.out.println("====================");
        System.out.println("已分配的内存块表");
        System.out.println("起始地址\t\t大小\t\t程序名");
        for(int i=0;i<usedBlock .size();i++){
            System.out.println(usedBlock .get(i).getStartAddress()+"\t\t"+usedBlock .get(i).getSize()+"\t"+usedBlock .get(i).getState());
            aList.add(usedBlock.get(i));
        }
        System.out.println("=======================");
            System.out.println("未分配的内存块表");
            System.out.println("起始地址\t\t大小\t\t状态");
            for(int i=0;i<unusedBlock .size();i++){
                System.out.println(unusedBlock  .get(i).getStartAddress()+"\t\t"+unusedBlock  .get(i).getSize()+"\t"+unusedBlock  .get(i).getState());
                aList.add(unusedBlock .get(i));
            }
            System.out.println("=======================");
            System.out.println();
            System.out.println("分区的初始化如下");
            //先把分配的和未分配的按顺序记录在顺序表中
            //然后再排序
            aList.sort(new FirstAdapation());

            //输出地址
            /* 注释
            * 首行输出起始地址（aList已经是按地址升序排列
            * 接下来寻找它的结束地址也就是下一个块的首地址*/
            /*for(int i=0;i<aList.size();i++){
                System.out.printf("%10d---------\n",aList.get(i).getStartAddress());
                boolean first=true;
                /*例如已有的0		500		A
                500		     800		D
                2500		1500		C
                5500		500		    B
                =======================
                未分配的内存块表
                起始地址		大小		状态
                1300		1200		unused
                4000		1500		unused
                 i=0 j=0 j<(500+1000)/1000 正确 输出它的状态为 A f=false
                j=1 j<( 500+1000)/1000 错误

                进行第二次外部循环 i=1 j=0 0<(800+1000)/1000 输出状态 D
                 j=1 i<(800+1000)/100 错误跳出循环
                 进行外部第三次循环 i=1 j=0 0<(1200)/1000+1 first=false 是输出它的状态 unused
                  j=1 1<(1200)/1000+1 正确  但first=false 输出 \ \*/
               /* for(int j=0;j<(aList.get(i).getSize()+1000)/1000;j++){
                    if(first){
                        System.out.println("         |        |"+aList.get(i).getState() );
                        first=false;
                    }else{
                        System.out.println("         |        |");
                    }
                }*/

                for(int k=0;k<aList.size();k++){
                    System.out.printf("%10d---------\n",aList.get(k).getStartAddress());
                    System.out.println("         |        |"+aList.get(k).getState() );
                    if(aList.get(k).getStartAddress() +aList.get(k).getSize() ==6000){
                        System.out.printf("%10d---------\n",aList.get(k).getStartAddress() +aList.get(k).getSize() );
                    }

                }
                //总共内存空间大小为6000
                /*if(aList.get(i).getStartAddress() +aList.get(i).getSize() ==6000){
                    System.out.printf("%10d---------\n",aList.get(i).getStartAddress() +aList.get(i).getSize() );
                    System.out.println("         |        |"+aList.get(i).getState() );
                }*/
            }
    //}

    //内存分配
    public void runAllocate(String programName,int programSize){
        boolean flag=false;
        //利用比较器进行排序阶段
        switch(memoryAllocation){
            case 1:
                unusedBlock.sort(new FirstAdapation());
                break;
            case 2:
                unusedBlock .sort(new FirstAdapation());
                break;
            case 3:
                unusedBlock.sort(new BestAdapation());
                break;
            case 4:
                unusedBlock.sort(new WorestAdapation());
                break;
            default:
                System.out.println("输入错误，请输入(1-4):");
                break;

        }
        //分配阶段
        for(int i=temp;i<unusedBlock.size();i++){//i=0
            MemoryBlock m=unusedBlock.get(i);
            if(m.getSize()>=programSize){
                //存在未分配的空闲区间的大小大于要分配空间的大小
                flag=true;
                //小于门限值就不单独形成空闲分区，直接加入分配列表
                //直接把要分配的块的地址大小，改成找到的这个分区的大小块，表示已经分配
                if(memoryAllocation==2){
                    if(temp==unusedBlock.size()-1){
                        temp=0;
                    }else{
                        temp=i+1;
                    }
                }
                if(m.getSize()-programSize <=limit){
                    usedBlock.add(new MemoryBlock(programName,m.getStartAddress(),m.getSize()));
                }else{
                    //若大于等于最小门限
                    //则已经分配的块加入已分配列表中
                    //剩余的未分配完的加入空闲列表中
                    usedBlock.add(new MemoryBlock(programName ,m.getStartAddress(),programSize));
                    //同时在未分配表中加上剩余的空间，供后续来分配，起始地址为加上已分配的程序大小，内存大小为原来的减去已分配的内存大小
                    unusedBlock.add(new MemoryBlock("unused",m.getStartAddress()+programSize,m.getSize()-programSize));
                }
                //在未分配的列表中移除原来的进程的地址，大小信息
                unusedBlock.remove(i);
                break;
            }
        }
        if(flag==false){
            System.out.println("没有空闲块可以满足");
        }
        print();
    }
    //回收
    public void recover(String programName){
        usedBlock.sort(new FirstAdapation());
        unusedBlock.sort(new FirstAdapation());
        boolean flag=false;
        int index=0;
        for(int i=0;i<usedBlock .size();i++){
            //寻找是否有需要寻找的进程
            if(usedBlock.get(i).getState().equals(programName)){
                flag=true;
                index=i;
                break;
            }
        }
        //如果没有找到该进程就输出信息，无法回收
        if(flag==false){
            System.out.println("找不到程序，无法回收该程序");
        }else{
            //找到该进程取出该进程
            MemoryBlock m=usedBlock .get(index);
            //判断上邻，下邻，上下邻，上下都不邻
            boolean up=false;
            boolean down=false;
            int upIndex=0,downIndex=0;
            for(int j=0;j<unusedBlock .size();j++){
                //上邻
                //地址为上邻区加上大小为此区块的首地址
                if(m.getStartAddress() ==unusedBlock .get(j).getStartAddress() +unusedBlock .get(j).getSize() ){
                    upIndex =j;
                    up=true;
                }
                //下邻
                if(m.getStartAddress()+m.getSize() ==unusedBlock .get(j).getStartAddress() ){
                    downIndex =j;
                    down=true;
                }
            }
            //上邻下邻
            //大小为三者之和，首地址为上邻区的地址
            if(up==true&&down==true){
                MemoryBlock mb=new MemoryBlock("unused",unusedBlock .get(upIndex ).getStartAddress() ,m.getSize() +unusedBlock .get(upIndex).getSize() +unusedBlock .get(downIndex ).getSize() );

                usedBlock .remove(index);//再已分配的列表中删除要释放的区
                unusedBlock .remove(upIndex);//删除上邻区
                unusedBlock .remove(downIndex -1);//删除了下邻区的上一个，即目的快区
                unusedBlock .add(mb);//把构成新的空闲区加入其中
            }else if(up==true&&down==false){
                //上邻下不邻
                unusedBlock .add(new MemoryBlock("unused",unusedBlock.get(upIndex ).getStartAddress(),m.getSize() +unusedBlock .get(upIndex).getSize()));
                usedBlock.remove(index);
                //删除上邻区
                unusedBlock .remove(upIndex );
            }else if(up==false&&down==true){
                //上不邻下邻
                unusedBlock .add(new MemoryBlock("unnsed",m.getStartAddress(),m.getSize()+unusedBlock.get(upIndex).getSize()) );
                usedBlock .remove(index);
                unusedBlock .remove(downIndex );
            }else{
                //上下都不邻
                unusedBlock .add(new MemoryBlock("unnsed",m.getStartAddress(),m.getSize()) );
                usedBlock .remove(index);
            }
        }
        print();
    }

    public void menu(){
        System.out.println("======================");
        System.out.println("1.首次适应算法");
        System.out.println("2.循环首次适应算法");
        System.out.println("3.最佳适应算法");
        System.out.println("4.最坏适应算法");
        System.out.println();

    }
    //排序比较器
    class FirstAdapation implements  Comparator <MemoryBlock >{
        public int compare(MemoryBlock b1,MemoryBlock  b2){
            return b1.getStartAddress()-b2.getStartAddress() ;
        }
    }
    class BestAdapation implements Comparator<MemoryBlock >{
        public int compare(MemoryBlock b1,MemoryBlock  b2){
            return b1.getSize() -b2.getSize() ;
        }
    }
    class WorestAdapation implements Comparator <MemoryBlock >{
        public int compare(MemoryBlock b1,MemoryBlock  b2){
            return b2.getSize() -b1.getSize() ;
        }
    }
}
