package com.konloch.disklib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * Small gzip compression and decompression util
 *
 * @author Konloch
 * @since Oct 18, 2014
 */
public class GZip
{
	private static final int BUFFER_SIZE = 1024;
	
	/**
	 * Compress a byte[] using GZip Compression (ZLib)
	 *
	 * @param data byte Array of any size
	 * @return compressed byte Array with GZip Compression (ZLib)
	 */
	public static byte[] compress(byte[] data)
	{
		//build the compressor
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		
		//create the output buffer
		ByteArrayOutputStream outputStream = null;
		
		//compress each byte chunk and write it to the byte array stream
		try
		{
			outputStream = new ByteArrayOutputStream(data.length);
			deflater.finish();
			
			byte[] buffer = new byte[BUFFER_SIZE];
			while (!deflater.finished())
			{
				outputStream.write(buffer, 0, deflater.deflate(buffer));
			}
		}
		finally
		{
			try
			{
				if(outputStream != null)
					outputStream.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return outputStream.toByteArray();
	}
	
	/**
	 * Decompress a byte[] using GZip Compression (ZLib)
	 *
	 * @param data compressed GZIP (ZLib) byte Array of any size
	 * @return decompressed byte Array with GZip Compression (ZLib)
	 * @throws DataFormatException if the compressed data format is invalid
	 */
	public static byte[] decompress(byte[] data) throws DataFormatException
	{
		//create the decompressor
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		
		//create the output buffer
		ByteArrayOutputStream outputStream = null;
		
		//decompress each byte chunk and write it to the byte array stream
		try
		{
			outputStream = new ByteArrayOutputStream(data.length);
			
			byte[] buffer = new byte[BUFFER_SIZE];
			while (!inflater.finished())
			{
				outputStream.write(buffer, 0, inflater.inflate(buffer));
			}
		}
		finally
		{
			try
			{
				if(outputStream != null)
					outputStream.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return outputStream.toByteArray();
	}
}