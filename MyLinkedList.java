public class MyLinkedList{
    private Node start;
    private Node end;
    private int length;
    public MyLinkedList(){
      length=0;
      start=null;
      end=null;
    }
    
  private Node getn(int n){
	  if(n<0 || n>length-1) {
		  throw new IndexOutOfBoundsException();
	  }
	  Node start=this.start;
	  for(int i=0;i<length-1;i++) {
		  if(i==n) {
			  return start;
		  }
		  else {
			  start=start.next();
		  }
		  
	  }
	  return end;
  }
  public boolean add(Integer i) {
	  
	  if(length<1) {
		  Node node=new Node(i,null,null);
		  start=node;
	  }
	  Node node=new Node(i,null,getn(length-1));
	  length++;
	  return true;
  }
  public int size() {
	  return this.length;
  }
  public String toString() {
	  String result="";
	  Node start=this.start;
	  for(int i=0;i<this.length-1;i++) {
		  result+=start.toString()+",";
		  start=start.next();
	  }
	  result+=start.toString();
	  return result;
  }
  public Integer get(int Index) {
	  return this.getn(Index).getData();
  }
  public Integer set(int Index,Integer value) {
	  if(Index<0|| Index>=this.length) {
		  throw new IndexOutOfBoundsException();
	  }
	  Node start=this.start;
	  for(int i=0;i<this.length-1;i++){
		  if(i==Index) {
			  return start.setData(value);
		  }
		  start=start.next();
	  }
	  return end.setData(value);
  }
  public boolean contains(Integer value) {
	  Node start=this.start;
	  for(int i=0;i<this.length;i++) {
		  if(start.getData()==value) {
			  return true;
		  }
		  start=start.next();
	  }
	  return false;
  }
  public int indexOf(Integer value) {
	  Node start=this.start;
	  for(int i=0;i<this.length;i++) {
		  if(start.getData()==value) {
			  return i;
		  }
		  start=start.next();
	  }
	  return -1;
  }
  public void add(int index,Integer value) {
	  if(index<0|| index>=this.length) {
		  throw new IndexOutOfBoundsException();
	  }
	  length++;
	  if(index==0) {
		  Node next=this.getn(index);
		  Node prev=next.prev();
		  Node current=new Node(value,next,prev);
		  prev.setNext(current);
		  next.setPrev(current);
		  start=current;
	  }
	  else if(index==length-1) {
		  Node next=this.getn(index);
		  Node prev=next.prev();
		  Node current=new Node(value,next,prev);
		  prev.setNext(current);
		  next.setPrev(current);
		  end=current;
	  }
	  else {
	    
		  
			  Node next=this.getn(index);
			  Node prev=next.prev();
			  Node current=new Node(value,next,prev);
			  prev.setNext(current);
			  next.setPrev(current);
			  
		     
	     
	  }
  }
  public Integer remove(int index) {
	  if(index<0 ||index>=this.length) {
		  throw new IndexOutOfBoundsException();
	  }
	  if(index==0) {
		  Integer answer=this.getn(index).getData();
		  this.start=this.getn(index+1);
		  start.setPrev(null);
		  return answer;
	  }
	  else if(index==length-1) {
		  Integer answer=this.getn(index).getData();
		  this.end=this.getn(index-1);
		  end.setNext(null);
		  return answer;
	  }
	  else {
			  Node prev=this.getn(index-1);
			  Node next=this.getn(index+1);
			  prev.setNext(next);
			  next.setPrev(prev);
			  return this.getn(index).getData();
		  
	  }
  }
  public boolean remove(Integer value) {
	  for(int i=0;i<this.length;i++) {
		  if(this.getn(i).getData()==value) {
			  this.remove(i);
			  return true;
		  }
	  }return false;
  }
  
 }

