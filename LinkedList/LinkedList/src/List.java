/**
 * 
 */

/**
 * @author rakshith
 *
 */
public interface List<T> extends Iterable<T> {
	int getCount();
	T get(int index);
	void set(int index, T data);
	void add(T data);
	void insert(int index, T data);
	void remove(T data);
	void removeAt(int index);
}
