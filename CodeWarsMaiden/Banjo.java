public class Banjo {
  public static String areYouPlayingBanjo(String name) {
    // Program me!
    String playtime = " does not play banjo";
    if(name.startsWith("R") || name.startsWith("r"))
    {
        playtime = " plays banjo";
    }
    return name + playtime;
  }
}