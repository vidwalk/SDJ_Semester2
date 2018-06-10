
public class main {
public static void main(String[] args)
{
CookieJar jar = new CookieJar();
CookieBaker baker = new CookieBaker(jar);
CookieEater eater = new CookieEater(jar);
Thread bakerBOI = new Thread(baker, "bakerBOI");
Thread eaterBOI = new Thread(eater, "eaterBOI");
bakerBOI.start();
eaterBOI.start();
}
}
