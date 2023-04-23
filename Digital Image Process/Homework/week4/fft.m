f = imread('C:\Users\32183\Desktop\MyCode\Digital Image Process\Homework\week4\f0303.tif');

%傅里叶变换
F = fft2(f);           %傅里叶变换
S=abs(F);              %傅里叶谱
Fc = fftshift(F);      %将变换的原点移动到频率矩形的中心
S2 = log(1+abs(Fc));
F = ifftshift(Fc);
phi = atan2(imag(F),real(F));
phi = angle(F);
F=S.*exp(i*phi);

subplot(231);imshow(f);title('原图');
subplot(232);imshow(F,[]);title('傅里叶变换');
subplot(233);imshow(S,[]);title('傅里叶频谱')
subplot(234);imshow(S2,[]);title('对数变换后的谱')
subplot(235);imshow(phi,[]);title('phi');
imwrite(phi,'C:\Users\32183\Desktop\MyCode\Digital Image Process\Homework\week4\f0303.jpg','quality',100);

