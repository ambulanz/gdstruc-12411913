package com.lanzgaborno;

public class SimpleHashtable {
    private StoredPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        // if slot is occupied, use linear probing (SKIPS THIS ENTIRE STATEMENT OTHERWISE)
        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            if (hashtable[hashedKey].getKey().equals(key)) {
                hashtable[hashedKey] = new StoredPlayer(key, value);
                System.out.println("Updated: " + key + " at index " + hashedKey);
                return;
            }

            hashedKey++;
            hashedKey %= hashtable.length;

            while (isOccupied(hashedKey) && hashedKey != stoppingIndex) {
                if (hashtable[hashedKey].getKey().equals(key)) {
                    hashtable[hashedKey] = new StoredPlayer(key, value);
                    System.out.println("Updated: " + key + " at index " + hashedKey);
                    return;
                }

                hashedKey++;
                hashedKey %= hashtable.length;
            }

            if (hashedKey == stoppingIndex) {
                System.out.println("Hashtable is full! Cannot add " + key);
                return;
            }
        }

        hashtable[hashedKey] = new StoredPlayer(key, value);
        System.out.println("Added: " + key + " at index " + hashedKey);
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);

        if (!isOccupied(hashedKey)) {
            return -1;
        }

        if (hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        int stoppingIndex = hashedKey;
        hashedKey++;
        hashedKey %= hashtable.length;

        while (isOccupied(hashedKey) && hashedKey != stoppingIndex) {
            if (hashtable[hashedKey].getKey().equals(key)) {
                return hashedKey;
            }

            hashedKey++;
            hashedKey %= hashtable.length;
        }

        return -1;
    }

    public Player get(String key) {
        int index = findKey(key);

        if (index == -1) {
            return null;
        }

        return hashtable[index].getValue();
    }

    // THE REMOVE FUNCTION FOR QUIZ ANSWER
    public Player remove(String key) {
        int index = findKey(key);

        if (index == -1) {
            System.out.println("Cannot remove: " + key + " not found");
            return null;
        }

        Player removedPlayer = hashtable[index].getValue();

        hashtable[index] = null;

        System.out.println("Removed: " + key + " from index " + index);

        rehashAfterRemove(index);

        return removedPlayer;
    }

    // rehash elements after removing for linear probing to no break
    private void rehashAfterRemove(int removedIndex) {
        int currentIndex = (removedIndex + 1) % hashtable.length;

        while (isOccupied(currentIndex)) {
            StoredPlayer storedPlayer = hashtable[currentIndex];
            String key = storedPlayer.getKey();
            Player value = storedPlayer.getValue();

            int properIndex = hashKey(key); //intended element location

            // if bumped by the element that was actually removed, places it back to intended location
            if (isInRehashRange(properIndex, removedIndex, currentIndex)) {
                hashtable[currentIndex] = null;  // Clear current spot
                int newIndex = findEmptySlot(properIndex);
                hashtable[newIndex] = storedPlayer;

                System.out.println("Rehashed: " + key + " from index " + currentIndex + " to " + newIndex);
            }

            currentIndex++;
            currentIndex %= hashtable.length;

            if (currentIndex == removedIndex) {
                break;
            }
        }
    }

    //checks if index is in the range that needs rehashing
    private boolean isInRehashRange(int properIndex, int removedIndex, int currentIndex) {
        if (removedIndex < currentIndex) {
            return properIndex <= removedIndex || properIndex > currentIndex;
        } else {
            return properIndex <= removedIndex && properIndex > currentIndex;
        }
    }

    private int findEmptySlot(int startIndex) {
        int index = startIndex;

        while (isOccupied(index)) {
            index++;
            index %= hashtable.length;
        }

        return index;
    }

    public void printHashtable() {
        System.out.println("\n===== HASHTABLE CONTENTS =====");
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("Element " + i + ": null");
            } else {
                System.out.println("Element " + i  + ": "+hashtable[i].getValue());
            }
        }
    }
}
