public class Codec {
    Map<String,String> map = new HashMap<>();
    int num = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        num++;
        String tiny = "http://tinyurl.com/" + num; 
        map.put(tiny , longUrl );
        return tiny;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));