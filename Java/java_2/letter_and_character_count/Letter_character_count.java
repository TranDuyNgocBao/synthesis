/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letter_and_character_count;

/**
 *
 * @author ADMIN
 */
public class Letter_character_count {
    public static void main(String[] args) {
        StringArray cd = new StringArray(Utils.getString("String: "));
        cd.countLetters();
        cd.countCharacter();
    }
}
