f = imread('C:\Users\32183\Desktop\MyCode\Digital Image Process\Homework\week4\f0303.tif');

%����Ҷ�任
F = fft2(f);           %����Ҷ�任
S=abs(F);              %����Ҷ��
Fc = fftshift(F);      %���任��ԭ���ƶ���Ƶ�ʾ��ε�����
S2 = log(1+abs(Fc));
F = ifftshift(Fc);
phi = atan2(imag(F),real(F));
phi = angle(F);
F=S.*exp(i*phi);

subplot(231);imshow(f);title('ԭͼ');
subplot(232);imshow(F,[]);title('����Ҷ�任');
subplot(233);imshow(S,[]);title('����ҶƵ��')
subplot(234);imshow(S2,[]);title('�����任�����')
subplot(235);imshow(phi,[]);title('phi');
imwrite(phi,'C:\Users\32183\Desktop\MyCode\Digital Image Process\Homework\week4\f0303.jpg','quality',100);

