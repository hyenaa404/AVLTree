
package model;

/**
 *
 * @author LENOVO
 */
public class SolarSystemTree  extends AVLTree<SolarSystem> {

    public SolarSystemTree() {
        super();
    }
    
    public void displaySolarSystemInf(AVLNode<SolarSystem> p){
        System.out.printf("%-20s|%-20s|%-15s|%-15s|%-15s|\n","Name", "Equatorial Diameter", "Mass", "Semi Major Axis", "Orbital Period");
        super.inOrderTraversal(p);
    }
    
//    public AVLNode<SolarSystem> searchByName(AVLNode<SolarSystem> p, SolarSystem x){
//        
//        if (p.getData().getName().equalsIgnoreCase(x.getName())) {
//            return (p);
//        }
//        searchByName(p.getLeft(), x);
//        searchByName(p.getRight(), x);
//        return null;
//    }
    
}
