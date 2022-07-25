/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author ADMIN
 */
public class Candidate {

    private int n;

    private String string;

    public Candidate(String string) {
        this.string = string;
    }

    public Candidate() {
    }

    public Candidate(int n) {
        this.n = n;
    }

    public Candidate(int n, String string) {
        this.n = n;
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int Candidateld(int a) {
        return a;
    }

    public String FirstName(String str) {
        return str;
    }

    protected String LastName(String str) {
        return str;
    }

    protected String BirthDate(String str) {
        return str;
    }

    protected String Address(String str) {
        return str;
    }

    protected int Phone(int a) {
        return a;
    }

    protected String Email(String str) {
        return str;
    }

    protected int Candidatetype(int a) {
        return a;
    }

    public void creating() {
    }

    protected void updating() {

    }

    protected void deleting() {

    }

    protected void searching() {

    }

}
