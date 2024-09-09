class Twitter {

  int time;
  Map<Integer, List<int[]>> tweets;
  Map<Integer, Set<Integer>> followers;

  public Twitter() {
    time = 0;
    followers = new HashMap<>();
    tweets = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] { tweetId, time++ });
  }

  public List<Integer> getNewsFeed(int userId) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

    if (tweets.containsKey(userId)) {
      for (int[] tweet : tweets.get(userId)) {
        pq.offer(tweet);
      }
    }

    if (followers.containsKey(userId)) {
      for (int follower : followers.get(userId)) {
        if (tweets.containsKey(follower)) {
          for (int[] tweet : tweets.get(follower)) {
            pq.offer(tweet);
          }
        }
      }
    }

    int k = 10;
    List<Integer> res = new ArrayList<>();
    while (k > 0 && !pq.isEmpty()) {
      res.add(pq.poll()[0]);
      k--;
    }

    return res;

  }

  public void follow(int followerId, int followeeId) {
    followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    if (!followers.containsKey(followerId))
      return;
    followers.get(followerId).remove(followeeId);
  }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */