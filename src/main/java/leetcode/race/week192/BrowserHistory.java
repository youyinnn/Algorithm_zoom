package leetcode.race.week192;

import java.util.Stack;

public class BrowserHistory {

    private String currentPage;
    private Stack<String> fStack = new Stack<>();
    private Stack<String> bStack = new Stack<>();

    public BrowserHistory(String homepage) {
        this.currentPage = homepage;
    }
    
    public void visit(String url) {
        bStack.push(this.currentPage);
        this.currentPage = url;
        fStack.clear();
    }
    
    public String back(int steps) {
        while (!bStack.empty() && steps != 0) {
            currentPage = bStack.pop();
            fStack.push(currentPage);
            steps--;
        }
        return currentPage;
    }
    
    public String forward(int steps) {
        while (!fStack.empty() && steps != 0) {
            currentPage = fStack.pop();
            bStack.push(currentPage);
            steps--;
        }
        return currentPage;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        browserHistory.back(1);                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        browserHistory.back(1);                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        browserHistory.forward(1);                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        browserHistory.forward(2);                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        browserHistory.back(2);                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        browserHistory.back(7);                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }

}