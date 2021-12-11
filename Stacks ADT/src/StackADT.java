import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackADT<T> implements Stack<T>{
	
	List<T> position = null;
	public StackADT() {
		this.position = new PositionsList<T>();
	}
	@Override
	public void push(T elem) {
		this.position.addFirst(elem);
	}
	@Override
	public boolean isEmpty() {
		
		return this.position.isEmpty();
	}
	@Override
	public int size() {
		
		return this.position.size();
	}
	@Override
	public T pop() throws EmptyStackException {
		Node<T> lastElement = this.position.search(this.position.first().element);
		
		return this.position.remove(lastElement);
	}
	@Override
	public T top() throws EmptyStackException {
		// TODO Auto-generated method stub
		return this.position.first().element;
	}
	
	

}
