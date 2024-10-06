package Day19;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NIOWrite {
	
	public static void main(String[]args) {
		
		try {
			Path path = Path.of("abc.txt");
			FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
			String contentString = "-";
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.put(contentString.getBytes());
			buffer.flip();
			fileChannel.write(buffer);
			
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}

}
