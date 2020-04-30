package Course;

public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}
	public static IntList squre(IntList L){
		if(L == null){
			return L;
		}else {
			IntList rest = squre(L.rest);
			IntList m = new IntList(L.first*L.first,rest);
			return m;
		}
	}
	public static IntList squre2(IntList L){
		IntList l = L;
		while(L.rest !=null){
			L.first = L.first*L.first;
			L = L.rest;
		}
		return L;
	}
	public static IntList squre3(IntList L){
		if(L == null){
			return L;
		}else{
			L.first = L.first * L.first;
			squre3(L.rest);
		}
		return L;
	}
	public static IntList ilsans(IntList L, int y) {
		if (L == null) {
			return null;
		}
		if (L.first == y) {
			return ilsans(L.rest, y);
		}
		return new IntList(L.first, ilsans(L.rest, y));
	}
	public static IntList dislans(IntList L, int y){
		if(L == null){
			return null;
		}
		L.rest = dislans(L.rest,y);
		if(L.first == y){
			return L.rest;
		}
		return L;
	}

	public static void main(String[] args) {
//		IntList L = new IntList(15, null);
//
//		L = new IntList(10, L);
//		L = new IntList(5, L);
//		squre3(L);
////		System.out.println(L.first);
////		System.out.println(L.rest.first);
//
//
//		for(IntList m = L;m.rest !=null;m = m.rest){
//			System.out.println(m.first);
//		}
//		System.out.println(L.get(100));


		IntList a = new IntList(1,null);
		for(int i = 0;i<10;i++){
			a = new IntList(i,a);
		}
		ilsans(a,2);
	}
} 