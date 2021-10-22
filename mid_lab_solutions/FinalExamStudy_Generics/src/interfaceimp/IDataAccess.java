package interfaceimp;

public interface IDataAccess<T,C> {
	T getConnection(C c);
}
