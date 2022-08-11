/**------------------------------------------------------------------------------
  MIT License

  Copyright (c) 2022 JumperBot_

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in all
  copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  SOFTWARE.
*-----------------------------------------------------------------------------**/

package SomeUtils.Storage;

public class Inventory<Item>{
	// Just a demo.
	public static void main(final String[]a){
		final Inventory<String> inventory=new Inventory<>(9);
		inventory.store("Number 1", 0);
		inventory.store("Number 2", 0); // Bump!
		inventory.storeMultiple(
			"Number 1", "Number 2", "Number 1", "Number 2",
			"Number 1", "Number 2", "Number 1"
		); // Bumps!

		System.out.println("This is what the inventory looks like:");
		System.out.println("Items:  "+java.util.Arrays.toString(inventory.getArray()));
		System.out.println("Amount: "+java.util.Arrays.toString(inventory.getItemCounts()));
		System.out.println();
		
		System.out.println("This is what it looks like if we stack them altogether:");
		inventory.setStackable();
		inventory.stack();
		System.out.println("Items:  "+java.util.Arrays.toString(inventory.getArray()));
		System.out.println("Amount: "+java.util.Arrays.toString(inventory.getItemCounts()));
		System.out.println();
		
		System.out.println("This is what it looks like if we pack them altogether:");
		inventory.pack();
		System.out.println("Items:  "+java.util.Arrays.toString(inventory.getArray()));
		System.out.println("Amount: "+java.util.Arrays.toString(inventory.getItemCounts()));
		System.out.println();

		System.out.println("This is a random segment of the demo:");
		final java.util.Random rand=new java.util.Random();
		final StringBuilder s=new StringBuilder("Number ");
		final StringBuilder notStored=new StringBuilder("[");
		for(int i=0;i<50;i++){
			final int temp=rand.nextInt(10);
			s.append(String.valueOf(temp));
			if(!inventory.store(s.toString().trim(), 0)){
				System.out.println("Number: "+temp+" Was Not Stored Due To Overflow.");
				break;
			}
			inventory.stack();
			s.deleteCharAt(7);
		}
		System.out.println("Items:  "+java.util.Arrays.toString(inventory.getArray()));
		System.out.println("Amount: "+java.util.Arrays.toString(inventory.getItemCounts()));
	}
	// The Class itself
	final Item[] storage;
	final int[] itemCount;
	final int length;
	final int half;
	@SuppressWarnings("unchecked")
	public Inventory(final int size){
		length=size;
		storage=(Item[])new Object[length];
		itemCount=new int[length];
		half=length/2+1;
	}
	boolean isStackable=false;
	public void setStackable(){
		isStackable=!isStackable;
	}
	public void stack(){
		if(!isStackable)return;
		for(int i=0;i<length;i++)
			if(itemCount[i]!=0)
				for(int j=i+1;j<length;j++)
					if(storage[j]!=null&&storage[j].equals(storage[i])){
						itemCount[i]+=getItemCount(j);
						dropAll(j);
					}
	}

	public void pack(){
		for(int i=1;i<length;i++)
			if(itemCount[i]!=0)
				for(int j=0;j<i;j++)
					if(itemCount[j]==0){
						storage[j]=storage[i];
						itemCount[j]+=getItemCount(i);
						dropAll(i);
						break;
					}
	}

	private boolean store(final Item item, final int ind, final boolean cycle){
		if(item==null)return false;
		if(itemCount[ind]==0){
			storage[ind]=item;
			itemCount[ind]=1;
			return true;
		}
		if(storage[ind].equals(item)&&isStackable){
			itemCount[ind]++;
			return true;
		}
		if(cycle)
			for(int i=0;i<half;i++){
				try{
					if(store(item, i, false))return true;
					if(store(item, i+half, false))return true;
				}catch(final Exception e){}
			}
		return false;
	}
	public boolean store(final Item item, final int ind){
		return store(item, ind, true);
	}
	@SuppressWarnings("unchecked")
	public void storeMultiple(final Item... items){
		for(final Item i:items)store(i, 0);
	}
	public void add(final int ind){
		if(!isStackable)return;
		itemCount[ind]++;
	}

	public void drop(final int ind){
		itemCount[ind]-=1;
		if(itemCount[ind]<1){
			itemCount[ind]=0;
			storage[ind]=null;
		}
	}
	public void dropAll(final int ind){
		storage[ind]=null;
		itemCount[ind]=0;
	}
	
	public void clear(){
		for(int i=0;i<length;i++)dropAll(i);
	}
	
	public Item get(final int ind){
		return storage[ind];
	}
	public Item getAndDrop(final int ind){
		final Item returnMe=storage[ind];
		drop(ind);
		return returnMe;
	}
	
	public int getItemCount(final int ind){
		return itemCount[ind];
	}
	public int[] getItemCounts(){
		final int[] copy=new int[length];
		System.arraycopy(itemCount, 0, copy, 0, length);
		return copy;
	}
	
	public String[] toArray(){
		return getArray();
	}
	public String[] getArray(){
		final String[] copy=new String[length];
		System.arraycopy(storage, 0, copy, 0, length);
		return copy;
	}

	public int size(){
		return length;
	}
	public int length(){
		return length;
	}
}
