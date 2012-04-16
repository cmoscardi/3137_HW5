package com.assignment2;

public class HashTable {
	String[] words;
	int size;
	public HashTable(int size){
		this.size=size;
		words = new String[this.size];
		
	}
	
	public void addWord(String word){
		int hash = hash(word);
		//collision, time to probe
		if(words[hash]!=null){
			//System.out.println("poops!");
			for(int i=0;i<size;i++){
				if(words[(hash+i)%size]==null){
					words[(hash+i)%size]=word;
					//System.out.println((hash+i)%size);
					break;
				}
				if(i==size-1){
					//THIS SHOULD NEVER HAPPEN
					System.out.println("er table is full?");
				}
			}
		}
		else{
			words[hash]=word;
		}
		
	}
	
	public boolean lookup(String word){
		int hash = hash(word);
		if(words[hash]==null){
			//System.out.println("hash position null");
			return false;
		}
		else if(!(words[hash].equals(word))){
			for(int i=0;i<size;i++){
				if(words[(hash+i)%size]==null){
					//System.out.println("probed, null at some point");
					return false;
				}
				else if(words[(hash+i)%size].equals(word)){
					return true;
				}
			}
			//THIS SHOULD NEVER HAPPEN
			System.out.println("!!!");
			return false;
		}
		else return true;
	}
	
	public int hash(String word){
		int hash = word.hashCode();
		hash%=size;
		if(hash<0){
			hash+=size;
		}
		return hash;
	}
	
	
}
