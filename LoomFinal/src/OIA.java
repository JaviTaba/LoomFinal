
public class OIA {
	int[]winners;
	
	public List<Integer> createPeopleList(){
		Reader readerwriter = new Reader();
		int amountOfPeople = readerwriter.getAmountOfPeople();
		
		List<Integer> list = new List<Integer>(1);
		for(int i=2; i<=amountOfPeople; i++) {
			list.insertNodeAtEnd(i);
		}
		return list;
	}
	
	public int[] getPatron() {
		Reader readerwriter = new Reader();
		int[] pattern = readerwriter.getPattern();
		return pattern;
	}
	
	public void run() {
		Reader readerwriter = new Reader();
		List<Integer> list = createPeopleList();
		int[] pattern = getPatron();
		
		winners = new int[pattern.length];
		
	 	int aux = pattern[0];
		int j=0;
		for(int i=0; i<pattern.length; i++) {
			winners[j] = list.getElementAt(aux);
			list.deleteElementAt(aux);
			j++;
			if(pattern.length>1) {
				aux += pattern[i]+1;
			}
		}
		readerwriter.write(winners, list.getElementAt(0));
	}
	
	public void test() {
		List<Integer> list = new List<Integer>(1);
		
		list.insertNodeAtEnd(2);
		list.insertNodeAtEnd(3);
		list.insertNodeAtEnd(4);
		list.insertNodeAtEnd(5);
		list.insertNodeAtEnd(6);
		
		
		System.out.println(list.getElementAt(0));
		System.out.println(list.getElementAt(1));
		System.out.println(list.getElementAt(2));
		System.out.println(list.getElementAt(3));
		System.out.println(list.getElementAt(4));
		System.out.println(list.getElementAt(5));
		System.out.println(list.getElementAt(6));
		System.out.println(list.getElementAt(7));
		System.out.println(list.getElementAt(8));
		System.out.println(list.getElementAt(9));
		System.out.println(list.getElementAt(10));
		System.out.println(list.getElementAt(11));
		
		list.deleteElementAt(2);
		System.out.println("borro");
		System.out.println(list.getElementAt(0));
		System.out.println(list.getElementAt(1));
		System.out.println(list.getElementAt(2));
		System.out.println(list.getElementAt(3));
		System.out.println(list.getElementAt(4));
		System.out.println(list.getElementAt(5));
		System.out.println(list.getElementAt(6));
		System.out.println(list.getElementAt(7));
		System.out.println(list.getElementAt(8));
		System.out.println(list.getElementAt(9));
		System.out.println(list.getElementAt(10));
		System.out.println(list.getElementAt(11));
		

		
		
		
	}

}
