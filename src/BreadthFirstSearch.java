import java.util.*;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	LinkedList<ASearchNode> openList;
	HashMap<String, ASearchNode> closeList;

	
	@Override
	public String getSolverName(){
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot	(IProblemState problemState	) {
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() {

		openList = new LinkedList<>();
		closeList = new HashMap<>();
	}

	@Override
	public ASearchNode getOpen(	ASearchNode node) {
		if(isOpen(node)) {
			return node;
		}
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node) {
		return openList.contains(node);
	}
	
	@Override
	public boolean isClosed(ASearchNode node) {
		return closeList.containsKey(node._currentProblemState.toString());
	}

	@Override
	public void addToOpen(ASearchNode node) {
		openList.add(node);
	}

	@Override
	public void addToClosed(ASearchNode node) {
		closeList.put(node._currentProblemState.toString(),node);
	}

	@Override
	public int openSize(){
		return openList.size();
	}

	@Override
	public ASearchNode getBest() {
		ASearchNode ans = openList.remove();
		return ans;
	}

	

}
