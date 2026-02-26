package edu.uvg.hdt4;

public class StackFactory<T> {

   public IStack<T> getStack(int entry) {

	if (entry == 1)
        return new StackArrayList<T>();
    else if (entry == 2)
        return new StackVector<T>();
	else
        return new StackLista<T>(100);
   }

}
