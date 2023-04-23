OriginalImg = imread('C:\Users\32183\Desktop\MyCode\Digital Image Process\Homework\week5\week5\lena.bmp');
Gray = rgb2gray(OriginalImg);
Gray_fft = fft2(double(Gray));
Gray_fftshift= abs(fftshift(Gray_fft));

PG = angle(Gray_fft);
IFG = ifft2(Gray_fftshift);
IPG = ifft2(exp(j*PG));


figure;
subplot(221);imshow(log(Gray_fftshift+1),[]),title('图像频谱幅度');
subplot(222);imshow(angle(fftshift(Gray_fft)),[]),title('图像相位');
subplot(223);imshow(log(1+abs(IFG)),[]),title('图像频谱幅度的逆变换');
subplot(224);imshow(IPG,[]),title('图像相位的逆变换');

PQ=paddedsize(size(Gray));
D0=0.05*PQ(1);
HBW=hpfilter('btw',PQ(1),PQ(2),D0,2);
H=0.5+2*HBW;
ghf=dftfilt(Gray,H,'fltpoint'); %enhansed
ghf=gscale(ghf);



d0=20;  %阈值
[M ,N]=size(Gray);

img_f = fft2(double(Gray));%傅里叶变换得到频谱
img_f=fftshift(img_f);  %移到中间

m_mid=floor(M/2);%中心点坐标
n_mid=floor(N/2);  

h = zeros(M,N);%高斯低通滤波器构造
for i = 1:M
    for j = 1:N
        d = ((i-m_mid)^2+(j-n_mid)^2);
        h(i,j) = exp(-(d)/(2*(d0^2)));      
    end
end

img_lpf = h.*img_f;

img_lpf=ifftshift(img_lpf);    %中心平移回原来状态
img_lpf=uint8(real(ifft2(img_lpf)));  %反傅里叶变换,取实数部分

figure;
subplot(1,2,1);imshow(img_lpf);title('高斯低通滤波D0=20');
subplot(1,2,2),subimage(ghf)
title('强调滤波')


