import java.util.*;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	LinkedList<ASearchNode> openList;
	HashSet<ASearchNode> closeList;

	
	@Override
	public String getSolverName() 
	{
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
		closeList = new HashSet<>();
	}

	@Override
	public ASearchNode getOpen(	ASearchNode node) {
		if(isOpen(node)) {
			for (ASearchNode currNode : openList) {
				if (node.equals(currNode)) {
					openList.remove(currNode);
					return currNode;
				}
			}
		}
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node) {
		return openList.contains(node);
	}
	
	@Override
	public boolean isClosed(ASearchNode node) {
		return closeList.contains(node);
	}

	@Override
	public void addToOpen(ASearchNode node) {
		openList.add(node);
	}

	@Override
	public void addToClosed(ASearchNode node) {
 		closeList.add(node);
	}

	@Override
	public int openSize(){
		return openList.size();
	}

	@Override
	public ASearchNode getBest() {
		ASearchNode ans = openList.remove();

		//addToClosed(ans);
		return ans;
	}

	

}
