//简单的模拟Map--效率低的遍历查询法
public class CustomMap
{	
	private int size;
	private Entry[] entries = new Entry[20];
	private final class Entry
	{
		Object key;
		Object value;
	}
	
	public void put(Object key, Object value)
	{
		if(size == entries.length)
		{
			Entry[] newEntries = new Entry[size + 10];
							//src   srcPos  dest    destStartPos want2CopyLength
			System.arraycopy(entries, 0, newEntries, 0, entries.length);
			entries = newEntries;
		}
		for(int i = 0; i < size; i++)
		{
			if(key.equals(entries[i].key))
			{
				entries[i].value = value;
				return;
			}
		}
		Entry e = new Entry();
		e.key = key;
		e.value = value;
		entries[size] = e;
		size++;
	}
	
	public Object get(Object key)
	{
		for(int i = 0; i < size; i++)
		{
			if(key.equals(entries[i].key))
			{
				return entries[i].value;
			}
		}
		return null;
	}
	
	public long size()
	{
		return size;
	}
	
	public static void main(String[] args)
	{
		CustomMap m = new CustomMap();
		for(int i = 0; i < 40; i++)
		{
			m.put("姓名" + i,"张" + i);
		}
		for(int i = 0; i < 40; i++)
		{
			System.out.println(m.get("姓名" + i));
		}
	}
}