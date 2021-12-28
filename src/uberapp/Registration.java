package uberapp;
import java.io.IOException;
import java.util.ArrayList;

public interface Registration {
	void register(People p) throws IOException;

	ArrayList<People> getList();
}
