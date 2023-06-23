package srikar.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Model {

    private HashMap<String, ArrayList<String>> allListNames = new HashMap<>();

    public void addList(String listName, ArrayList<String> newList) throws IOException, ClassNotFoundException {
        allListNames.put(listName, newList);
        saveFile();
        readFile(new File("./data/data.txt"));

    }

    public void removeList(String listName) throws IOException, ClassNotFoundException {
        allListNames.remove(listName);
        saveFile();
        readFile(new File("./data/data.txt"));
    }

    public void renameList(String oldlistName, String newListName) throws IOException, ClassNotFoundException {
        allListNames.put(newListName, allListNames.get(oldlistName));
        removeList(oldlistName);
        saveFile();
        readFile(new File("./data/data.txt"));

    }

    public void replaceList(String listName, ArrayList<String> replacingList) throws IOException, ClassNotFoundException {
        allListNames.put(listName, replacingList);
        saveFile();
        readFile(new File("./data/data.txt"));
    }

    public ArrayList<String> viewList(String listName) {
        return allListNames.get(listName);
    }

    public void printList(String listName) {
        System.out.println(allListNames.get(listName));
    }

    public ArrayList<String> getAllListNames() {
        Object[] listNames = allListNames.keySet().toArray();
        ArrayList<String> namesFinal = new ArrayList<>();
        for (int i = 0; i < listNames.length; i++) {
            namesFinal.add((String) listNames[i]);
        }
        return namesFinal;
    }

    public void printAllLists() {
        ArrayList<String> listNames = getAllListNames();
        for (int i = 0; i < listNames.size(); i++) {
            printList(listNames.get(i));
        }
    }

    public void saveFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("./data/data.txt", false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(allListNames);
        oos.close();
        fos.close();
    }

    public void readFile(File file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        allListNames = (HashMap<String, ArrayList<String>>) ois.readObject();
        ois.close();
        fis.close();
    }

    public ArrayList<String> searchFor(String searchData) {
        ArrayList<String> listNames = getAllListNames();
        System.out.println(listNames);
        ArrayList<String> searchRes = new ArrayList<>();
        for (int i = 0; i < listNames.size(); i++) {

            if (listNames.get(i).equals(searchData) || allListNames.get(listNames.get(i)).contains(searchData) || allListNames.get(listNames.get(i)).contains("L:/" + searchData)) {
                //System.out.println("basd");
                searchRes.add(listNames.get(i));
                //System.out.println("here");
            }
        }
        return searchRes;
    }
}
