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
    public void recherche()
    {

    }
    public void printTree(BinaryTree bTree)
    {
        if(bTree!=null)
        {
            printTree(bTree.leftChildren);
            printTree(bTree.rightChildren);
            System.out.print(bTree.value+ " ");
        }

    }


    public static void main(String args[])
    {
        BinaryTree binaryTree=new BinaryTree(65);
        binaryTree.insertion(40);
        binaryTree.insertion(80);
        binaryTree.insertion(30);
        binaryTree.insertion(48);
        binaryTree.insertion(75);
        binaryTree.printTree(binaryTree);



    }
}
