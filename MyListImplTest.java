
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyListImplTest {

    private String zeroIndexNode = "index zero";
    private String oneIndexNode = "index one";
    private String twoIndexNode = "index two";
    private String threeIndexNode = "index three";

    @Test
    public void testSize() throws Exception {
        MyList<String> list = new MyListImpl<String>();
        Assert.assertEquals(list.size(), 0);

        list.add(zeroIndexNode);
        list.add(oneIndexNode);
        list.add(twoIndexNode);
        list.add(threeIndexNode);

        Assert.assertEquals(list.size(), 4);
    }

    @Test
    public void testAdd() throws Exception {
        MyList<String> list = new MyListImpl<String>();

        Assert.assertEquals(list.indexOf("index zero"), -1);
        Assert.assertEquals(list.size(), 0);

        list.add(zeroIndexNode);
        Assert.assertEquals(list.indexOf("index zero"), 0);
        Assert.assertEquals(list.size(), 1);

        list.add("hey");
        Assert.assertEquals(list.indexOf("hey"), 1);
        Assert.assertEquals(list.size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        MyList<String> list = new MyListImpl<String>();

        list.add(zeroIndexNode);
        list.add(oneIndexNode);
        list.add(twoIndexNode);
        list.add(threeIndexNode);

        Assert.assertEquals(list.get(0).getValue(), "index zero");

        list.remove(0);
        Assert.assertEquals(list.get(0).getValue(), "index one");
    }

    @Test
    public void testIsEmpty() throws Exception {
        MyList<String> list = new MyListImpl<String>();

        Assert.assertEquals(list.isEmpty(), true);

        list.add(zeroIndexNode);
        Assert.assertEquals(list.isEmpty(), false);

        list.remove(0);
        Assert.assertEquals(list.isEmpty(), true);
    }

    @Test
    public void testRemove() throws Exception {
        MyList<String> list = new MyListImpl<String>();

        list.add(zeroIndexNode);
        Assert.assertEquals(list.indexOf("index zero"), 0);
        Assert.assertEquals(list.size(), 1);

        list.remove(0);
        Assert.assertEquals(list.indexOf("index zero"), -1);
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void testContains() throws Exception {
        MyList<String> list = new MyListImpl<String>();

        list.add(zeroIndexNode);

        Assert.assertEquals(list.contains("index one"), false);
        Assert.assertEquals(list.contains("index zero"), true);

        list.remove(0);
        Assert.assertEquals(list.contains("index zero"), false);
    }

    @Test
    public void testIndexOf() throws Exception {
        MyList<String> list = new MyListImpl<String>();

        list.add(zeroIndexNode);
        list.add(oneIndexNode);

        Assert.assertEquals(list.indexOf("lalal"), -1);
        Assert.assertEquals(list.indexOf("index zero"), 0);
        Assert.assertEquals(list.indexOf("index one"), 1);

        list.remove(0);
        Assert.assertEquals(list.indexOf("index zero"), -1);
        Assert.assertEquals(list.indexOf("index one"), 0);
    }

    @Test
    public void testCountRepetition() throws Exception {
        MyList<String> list = new MyListImpl<String>();

        list.add(zeroIndexNode);
        list.add(oneIndexNode);
        list.add(oneIndexNode);
        list.add(oneIndexNode);

        Assert.assertEquals(list.countRepetition("index one"), 3);
        Assert.assertEquals(list.countRepetition("index zero"), 1);
        Assert.assertEquals(list.countRepetition("index lala"), 0);

        list.remove(0);
        Assert.assertEquals(list.countRepetition("index zero"), 0);

        list.remove(0);
        Assert.assertEquals(list.countRepetition("index one"), 2);
    }

    @Test
    public void testHasDuplicates() throws Exception {
        MyList<String> list = new MyListImpl<String>();

        Assert.assertEquals(list.hasDuplicates(), false);

        list.add(zeroIndexNode);
        list.add(oneIndexNode);
        list.add(oneIndexNode);

        Assert.assertEquals(list.hasDuplicates(), true);
        list.remove(1);
        Assert.assertEquals(list.hasDuplicates(), false);
    }

    @Test
    public void testListDuplicates() throws Exception {
        MyList<String> list = new MyListImpl<String>();

        list.add(zeroIndexNode);
        list.add(oneIndexNode);
        list.add(oneIndexNode);

        MyList<String> duplicates = list.listDuplicates();

        Assert.assertEquals(duplicates.size(), 1);
        Assert.assertEquals(duplicates.get(0).getValue(), "index one");

        list.add(zeroIndexNode);
        duplicates = list.listDuplicates();

        Assert.assertEquals(duplicates.size(), 2);
        Assert.assertEquals(duplicates.get(0).getValue(), "index zero");
        Assert.assertEquals(duplicates.get(1).getValue(), "index one");

        list.remove(0);
        list.remove(1);
        duplicates = list.listDuplicates();

        Assert.assertEquals(duplicates.size(), 0);
        Assert.assertEquals(duplicates.get(0), null);
    }
}