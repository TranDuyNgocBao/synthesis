package animal.v1;

/**
 *
 * @author Hoa Doan
 */
/* Interface for menu */
 public interface I_Menu {
   // add a menu item--> add text to menu
   void addItem(String s);
   // get user choice( user iput their choice
   int getChoice();
   // show menu for user choice
   void showMenu();
   
}
