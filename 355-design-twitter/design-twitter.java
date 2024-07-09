class Twitter {
  Map<Integer, HashSet<Integer>> followers;
  Map<Integer, List<int[]>> tweets;
  int timer;

  public Twitter() {
    followers = new HashMap<>();
    tweets = new HashMap<>();
    timer = 0;
  }

  public void postTweet(int userId, int tweetId) {
    if (!tweets.containsKey(userId)) {
      tweets.put(userId, new ArrayList<>());
    }
    tweets.get(userId).add(new int[] { tweetId, timer++ });
  }

  public List<Integer> getNewsFeed(int userId) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    if (tweets.containsKey(userId)) {
      for (int[] tweet : tweets.get(userId)) {
        pq.offer(tweet);
      }
    }

    if (followers.containsKey(userId) && !followers.get(userId).isEmpty()) {
      for (int id : followers.get(userId)) {
        if (tweets.containsKey(id)) {
          for (int[] tweet : tweets.get(id)) {
            pq.offer(tweet);
          }
        }
      }

    }

    List<Integer> res = new ArrayList<>();
    int k = 0;
    while (!pq.isEmpty() && k < 10) {
      res.add(pq.poll()[0]);
      k++;
    }

    return res;
  }

  public void follow(int followerId, int followeeId) {
    if (!followers.containsKey(followerId)) {
      followers.put(followerId, new HashSet<>());
    }
    followers.get(followerId).add(followeeId);
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