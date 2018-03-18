

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BinaryTree {
    private BinaryTree leftChildren; //l'enfant "gauche" du noeud
    private BinaryTree rightChildren; //l'enfant "droit" du noeud
    private int value; // la valeur du noeux
    public BinaryTree() // Un constructeur vide
    {}
    public BinaryTree(int value) // Un constructeur avec en paramètre la valeur du premier noeud
    {
        this.value=value;
    }

    public BinaryTree getLeftChildren() { // Obtenir l'enfant gauche
        return leftChildren;
    }
    public BinaryTree getRightChildren() {// Obtenir l'enfant droit
        return rightChildren;
    }
    public void setRightChildren(BinaryTree rightChildren) // remplacer l'enfant droit
    {
        this.rightChildren=rightChildren;
    }
    public void setLeftChildren(BinaryTree leftChildren) //remplacer l'enfant gauche
    {
        this.leftChildren=leftChildren;
    }
    public static Boolean insertion(BinaryTree binaryTree, int valueToInsert) // fonction d'insertion d'une valeur
    {
        if(valueToInsert<binaryTree.value) //si la valeur a inserer est plus petite que la valeur du noeud courant
        {
            if(binaryTree.leftChildren ==null) // et si il n'y a d'enfant à gauche
            {
                binaryTree.leftChildren=new BinaryTree(valueToInsert); //alors on en créé un avec la valeur à insérer
                return true;
            }
            else
                return insertion(binaryTree.leftChildren, valueToInsert); // sinon c'est qu'il y a un enfant, et du coup on "descend" dans l'enfant de gauche
        }
        else if(valueToInsert>binaryTree.value)// si la valeur a inserer est plus grande que celle du noeud courant
        {
            if(binaryTree.rightChildren==null) // si il n'y a pas d'enfant a droite
            {
                binaryTree.rightChildren=new BinaryTree(valueToInsert); // alors on le creer
                return true;
            }
            else
                return insertion(binaryTree.rightChildren, valueToInsert); // sinon on "descend" dans l'enfant de droite
        }
        return false; // on retourne faux pour signaler que l'insertion s'est mal passée
    }
    public int getValue() // obtenir la valeur d'un noeud
    {
        return value;
    }
    public int hauteur(BinaryTree binaryTree) // retourner la hauteur de l'arbre
    {
        if(binaryTree==null)
        {
            return 0;
        }
        else
            return (1+Math.max(hauteur(binaryTree.getLeftChildren()),hauteur(binaryTree.getRightChildren())));
    }

   public static void parcoursPrefixe(BinaryTree binaryTree)
   {
       System.out.print(binaryTree.value+ " - ");
       if(binaryTree.getLeftChildren()!=null)
       {
           parcoursPrefixe(binaryTree.leftChildren);
       }

       if(binaryTree.getRightChildren()!=null)
       {
          parcoursPrefixe(binaryTree.rightChildren);
       }
   }



    public static boolean recherche(BinaryTree binaryTree, int valueToLookFor) // fonction de recherche d'un element
    {
        boolean found=false;
        if(binaryTree.value==valueToLookFor) { //si la valeur du noeud courant est la même que celle recherchée
            found=true; // on a trouvé
        }
        else // sinon
            {
                if (binaryTree.value<valueToLookFor) // si elle est supérieure
                {
                    if(binaryTree.rightChildren!=null) // et qu'il y a un enfant droit
                       return recherche(binaryTree.rightChildren,valueToLookFor); // on recherche du côté de l'enfant droit
                    else // si il n'y a pas d'enfant droit
                        found=false; //alors la valeur n'existe pas
                }
                else // si elle est inférieure
                {
                    if(binaryTree.leftChildren!=null) // et qu'il y a un enfant gauche
                    {
                        return recherche(binaryTree.leftChildren,valueToLookFor);// alors on va rechercher du côté de l'enfant gauche
                    }
                    else // si il n'y a pas d'enfant gauche
                        found=false; // alors la valeur n'existe pas.
                }
            }
            return found;
    }

    public static void main(String args[])
    {
        ArrayList<String> datas=new ArrayList<String>(); // Creation d'une ArrayList de String pour l'affichage
        BinaryTree binaryTree=new BinaryTree(65); // On créer un arbre binaire avec "65" comme valeur dans le premier noeud
        insertion(binaryTree,40); // on insère quelques valeurs
        insertion(binaryTree,80);
        insertion(binaryTree,30);
        insertion(binaryTree,48);
        insertion(binaryTree,75);
        parcoursPrefixe(binaryTree);
        System.out.println();
        System.out.println(recherche(binaryTree,22)); // On vérifie que l'élement entier est dans l'arbre (True , trouvé, false, pas trouvé)
    }
}
