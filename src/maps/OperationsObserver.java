package maps;

import java.util.List;

public interface OperationsObserver {
	void notifyDataSet(Operations operations, Object output, String map);
}
