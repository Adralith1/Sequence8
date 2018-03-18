

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BinaryTree {
    private BinaryTree leftChildren;
    private BinaryTree rightChildren;
    private int value;
    public BinaryTree()
    {}
    public BinaryTree(int value)
    {
        this.value=value;
    }

    public BinaryTree getLeftChildren() {
        return leftChildren;
    }
    public BinaryTree getRightChildren() {
        return rightChildren;
    }
    public void setRightChildren(BinaryTree rightChildren)
    {
        this.rightChildren=rightChildren;
    }
    public void setLeftChildren(BinaryTree leftChildren)
    {
        this.leftChildren=leftChildren;
    }
    public Boolean insertion(int valueToInsert)
    {
        if(valueToInsert<this.value)
        {
            if(this.leftChildren ==null)
            {
                this.leftChildren=new BinaryTree(valueToInsert);
                return true;
            }
            else
                return leftChildren.insertion(valueToInsert);
        }
        else if(valueToInsert>this.value)
        {
            if(this.rightChildren==null)
            {
                this.rightChildren=new BinaryTree(valueToInsert);
            }
            else
                return this.rightChildren.insertion(valueToInsert);
        }
        return false;
    }
    public int getValue()
    {
        return value;
    }
    public int hauteur(BinaryTree binaryTree)
    {
        if(binaryTree==null)
        {
            return 0;
        }
        else
            return (1+Math.max(hauteur(binaryTree.getLeftChildren()),hauteur(binaryTree.getRightChildren())));
    }

    public ArrayList<String> getTreeDatas(BinaryTree bTree,int hauteur,int niveau, ArrayList<String> datas)
    {
        if(bTree==null)
        {
            datas.add(hauteur + " " + "X");
            return null;
        }
        datas.add(hauteur + " " + bTree.value);
        getTreeDatas(bTree.leftChildren,hauteur+1,niveau,datas);
        getTreeDatas(bTree.rightChildren,hauteur+1,niveau,datas);
        return datas;
    }

    public void printHashmapDatas(ArrayList<String> treeDatas)
    {
        String firstChar="";
        int firstCharInt=0;
        ArrayList<Integer> tabDeint=new ArrayList<Integer>();
        ArrayList<String> arbreLigneParLignes=new ArrayList<String>();
        boolean newLine=false;
        treeDatas.sort(String::compareToIgnoreCase);
        String tempStr="";
        for(int i=0;i<treeDatas.size();i++)
        {
            firstChar = treeDatas.get(i).substring(0, 1);
            firstCharInt = Integer.parseInt(firstChar);
            tabDeint.add(firstCharInt);
        }
       for(int i=0;i<treeDatas.size();i++) {
           firstChar = treeDatas.get(i).substring(0, 1);
           firstCharInt = Integer.parseInt(firstChar);

           if(firstCharInt!=tabDeint.get(i+1) ) {newLine=true;}
           else newLine=false;
           tabDeint.add(firstCharInt);
           tempStr += "\t";
           tempStr+=treeDatas.get(i).subSequence(1, treeDatas.get(i).length());
           tempStr+="\t";
           if(newLine)
           {
               tempStr+="\n";
           }
           arbreLigneParLignes.add(tempStr);
           tempStr="";
       }
       int cpt=0;
        for(int i=0;i<arbreLigneParLignes.get((arbreLigneParLignes.size()-1)).length()/2;i++)
            System.out.print("\t");
       for(int i=0;i<arbreLigneParLignes.size();i++) {
           if(arbreLigneParLignes.get(i)!="\t")
           {
               for(int j=0;j<i;j++)
               {
                   cpt++;
               }
           }
           System.out.print(arbreLigneParLignes.get(i));
           if(cpt%2==0)
           {
               System.out.print("\t");
           }
           cpt=0;
       }
    }

    public static boolean recherche(BinaryTree binaryTree, int valueToLookFor)
    {
        boolean found=false;
        if(binaryTree.value==valueToLookFor) {
            found=true;
        }
        else
            {
                if (binaryTree.value<valueToLookFor)
                {
                    if(binaryTree.rightChildren!=null)
                       return recherche(binaryTree.rightChildren,valueToLookFor);
                    else
                        found=false;
                }
                else
                {
                    if(binaryTree.leftChildren!=null)
                    {
                        return recherche(binaryTree.leftChildren,valueToLookFor);
                    }
                    else
                        found=false;
                }
            }
            return found;
    }

    public static void main(String args[])
    {
        ArrayList<String> datas=new ArrayList<String>();
        BinaryTree binaryTree=new BinaryTree(65);
        binaryTree.insertion(40);
        binaryTree.insertion(80);
        binaryTree.insertion(30);
        binaryTree.insertion(48);
        binaryTree.insertion(75);
        datas=binaryTree.getTreeDatas(binaryTree,binaryTree.hauteur(binaryTree),0,datas);
        //binaryTree.printHashmapDatas(datas);
        System.out.println(recherche(binaryTree,22));
    }
}
